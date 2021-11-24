package br.com.projeto.utd.repositorio;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projeto.utd.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
	@Query(value="SELECT * FROM livro WHERE"
			+ "MATCH(autor, titulo) "
			+ "AGAINST (?1)",
			nativeQuery = true)
	public List<Livro> search(String pesquisa); 
	
	
	
	
} 
