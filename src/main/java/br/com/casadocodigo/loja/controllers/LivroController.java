package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.LivroDAO;
import br.com.casadocodigo.loja.utils.FileSaver;
import br.com.casadocodigo.models.Livro;
import br.com.casadocodigo.models.TipoLivro;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroDAO livroDAO;

	@Autowired
	private FileSaver fileSaver;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setValidator(new LivroValidator());
	}

	@RequestMapping("form")
	public ModelAndView form(Livro livro) {

		ModelAndView mav = new ModelAndView("livro/form");

		mav.addObject("types", TipoLivro.values());

		return mav;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value="listProdutos",allEntries=true)
	public ModelAndView salvar(MultipartFile sumario, @Valid Livro livro, BindingResult result,
			RedirectAttributes attr) {
		System.out.println(livro.getTitulo());
		System.out.println(sumario.getOriginalFilename());
		if (result.hasErrors()) {
			System.out.println("erro");
			result.getFieldErrors().forEach(System.out::println);
			return form(livro);
		}

		if (!sumario.getOriginalFilename().trim().isEmpty()) {
			String webPath = fileSaver.write("/home/spring7142/arquivos-upload", sumario);
			livro.setCaminhoSumario(webPath);
		}

		// try {
		// livro.setArquivoSumario(sumario.getBytes());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		livroDAO.save(livro);
		attr.addFlashAttribute("msg", "Produto cadastrado");
		return new ModelAndView("redirect:livros");
	}

	@RequestMapping(method = RequestMethod.GET)
	@Cacheable(value="listProdutos")
	public ModelAndView listar() {

		ModelAndView mav = new ModelAndView("livro/list");

		mav.addObject("livros", livroDAO.listar());

		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ModelAndView detalhe(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("livro/detalhe");
		mav.addObject("livro", livroDAO.obter(id));
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/json")
	@ResponseBody
	public List<Livro> json() {
		return livroDAO.listar();
	}

}
