package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.LivroDAO;
import br.com.casadocodigo.models.Livro;
import br.com.casadocodigo.models.PagamentoRequest;
import br.com.casadocodigo.models.ShoppingCart;
import br.com.casadocodigo.models.ShoppingItem;
import br.com.casadocodigo.models.TipoLivro;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private ShoppingCart shopping;

	@Autowired
	private RestTemplate rest;

	@Autowired
	private LivroDAO livroDao;

	@RequestMapping(method = RequestMethod.POST)
	public String add(Long id, @RequestParam TipoLivro tipo) {
		shopping.add(criaItem(id, tipo));
		return "redirect:livros";
	}

	public ShoppingItem criaItem(Long id, TipoLivro tipo) {

		System.out.println(id);

		Livro livro = livroDao.obter(id);

		ShoppingItem item = new ShoppingItem(livro, tipo);

		return item;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/checkout")
	public Callable<String> checkout(RedirectAttributes attr) {

		return () -> {

			PagamentoRequest data = new PagamentoRequest(shopping.getTotal());

			String url = "http://book-payment.herokuapp.com/payment";
			try {
				String resp = rest.postForObject(url, data, String.class);

				System.out.println(resp);

			} catch (HttpClientErrorException e) {
				System.out.println("erro no pagamento " + e.getMessage());
				return "redirect:/livros";
			}

			attr.addFlashAttribute("msg", "pagamento efetuado com sucesso");

			shopping.limparCarrinho();

			return "redirect:/livros";

		};
	}
}
