package com.teste.cadastrousuario.bussiness;

import com.teste.cadastrousuario.infra.entitys.Usuario;
import com.teste.cadastrousuario.infra.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }


    public Usuario buscarUsuarioPorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                () ->new RuntimeException("Email não encontrado")
        );

    }
    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);

    }
    public void atualizarUsuario(String email,Usuario usuario){
        Usuario usuarioEntity = buscarUsuarioPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .build();

        repository.saveAndFlush(usuarioAtualizado);

    }
}

