package com.teste.cadastrousuario.controller;

import com.teste.cadastrousuario.bussiness.UsuarioService;
import com.teste.cadastrousuario.infra.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return  ResponseEntity.ok().build();
    }



    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return  ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));

    }
    @DeleteMapping
    public ResponseEntity<Void> detetarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return  ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> atalizarPorEmail(@RequestParam String email,
                                                 @RequestBody Usuario usuario){

        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }
}
