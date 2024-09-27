package com.proyect.fullstack_angular.controller;

import com.proyect.fullstack_angular.entity.Usuario;
import com.proyect.fullstack_angular.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/crear")
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @GetMapping("/allUsuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.readAll();
    }
    @GetMapping("/ById/{id}")
    public Usuario findById(@PathVariable Long id){
      return usuarioService.readById(id);
    }
    @PutMapping("/actiualizar{id}")
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.actializarUsuario(usuario);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
    }

}
