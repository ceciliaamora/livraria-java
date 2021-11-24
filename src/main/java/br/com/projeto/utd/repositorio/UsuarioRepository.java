package br.com.projeto.utd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.utd.entidades.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
