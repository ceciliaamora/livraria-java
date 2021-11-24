package br.com.projeto.utd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.utd.entidades.Livro;
import br.com.projeto.utd.repositorio.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository repo;
	
	public void adicionar(Livro livro) {
		
		repo.save(livro);
				
	}
	

	public List<Livro> listarLivros(){
		
		return repo.findAll();
		
	}

	public Livro modificar(Long id) {
		return repo.findById(id).get();
	}


	public void deletar(Long username) {
		repo.deleteById(username);
	}
	
	public List<Livro> search(String pesquisa){
		return repo.search(pesquisa); 
		
	
	}
}

