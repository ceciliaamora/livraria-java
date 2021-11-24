package br.com.projeto.utd.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.utd.entidades.Livro;
import br.com.projeto.utd.service.LivroService;

@Controller
public class LivrariaController {


	@Autowired
	LivroService servico;
	

	@RequestMapping("/")
	public String paginaInicial(Model model) {
		
			List<Livro> livros = servico.listarLivros();
		
		model.addAttribute("livros", livros); 
		
		
		return "index";
		
	}
	
	@RequestMapping(value="/painel")
	public String paginaAdministrador(Model model) {
		
		List<Livro> livros = servico.listarLivros();
		
		model.addAttribute("livros", livros); 
		
		
		
		return "administrador";
		
	}


	@RequestMapping(value="/cadastro")
	public String paginaCadastro(Model model) {
		
		Livro livro = new Livro();
		
		model.addAttribute("livro", livro);
		
		return "cadastrarLivro";
		
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String salvar(@ModelAttribute("livro") Livro livro) {
		
		servico.adicionar(livro);
		
		return "administrador";
		
	}

	
	@RequestMapping(value="/editar/{id}")
	public ModelAndView paginaEditar(@PathVariable(name="id") Long id) {
	
		ModelAndView mav = new ModelAndView("editarlivro");	
		
		Livro livro = servico.modificar(id);
		
		mav.addObject("livro", livro);
		
		return mav;
			
    }
	

	@RequestMapping(value="/deletar/{id}")
	public String deletar(@PathVariable(name="id") Long id) {
		
		servico.deletar(id);
		return "redirect:/";
		}
	

	@GetMapping("/search")
	public String search(@Param("pesquisa") String pesquisa, Model model) {
		
		List<Livro> searchResult = servico.search(pesquisa);
		model.addAttribute("pesquisa", pesquisa);
		model.addAttribute("pageTitle","Search results for '" + pesquisa + "'" );
		//model.addAttribute("searchResult", searchResult); 

		return "buscar";
	}  
	

}
		

