package com.proyect.fullstack_angular.service.impl;

import com.proyect.fullstack_angular.entity.Usuario;
import com.proyect.fullstack_angular.exceptions.ResourceNotFoundException;
import com.proyect.fullstack_angular.repository.UsuarioRepository;
import com.proyect.fullstack_angular.service.IUsuarioService;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;


    public Usuario create(Usuario usuario) {
        try {
            LocalDate currentDate = LocalDate.now();
            usuario.setFechaModificacion(currentDate);
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new ServiceException("Error al crear el usuario: " + usuario.getNombre(), e);
        }
    }


    @Override
    public List<Usuario> readAll() {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error al obtener la lista de usuarios.", e);
        }
    }

    @Override
    public Usuario readById(Long id) {

        Usuario usu = usuarioRepository.findById(id).orElseThrow(
                ()->{
                    throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
                }
        );
        return usuarioRepository.findById(id).get();

    }

    @Override
    public Usuario actializarUsuario(Usuario usuario) {
        return null;
    }


    @Transactional
    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        try {
            if (!usuarioRepository.existsById(usuario.getId())) {
                throw new ResourceNotFoundException("Usuario no encontrado con ID: " + usuario.getId());
            }
            LocalDate currentDate = LocalDate.now();
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar el usuario: " + usuario.getId(), e);
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        try {
            if (!usuarioRepository.existsById(id)) {
                throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
            }
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Error al eliminar el usuario con ID: " + id, e);
        }
    }

}
