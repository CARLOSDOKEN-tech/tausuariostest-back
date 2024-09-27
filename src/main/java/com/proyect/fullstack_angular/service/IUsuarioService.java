package com.proyect.fullstack_angular.service;

import com.proyect.fullstack_angular.entity.Usuario;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public Usuario create(Usuario usuario);

    public List<Usuario> readAll();

    public Usuario readById(Long id);

    public Usuario actializarUsuario(Usuario usuario);

    @Transactional
    Usuario actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(Long id);


}
