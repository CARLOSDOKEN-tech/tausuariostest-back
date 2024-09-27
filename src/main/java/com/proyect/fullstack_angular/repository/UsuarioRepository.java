package com.proyect.fullstack_angular.repository;

import com.proyect.fullstack_angular.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   public Optional<Usuario> findById(Long id);
}
