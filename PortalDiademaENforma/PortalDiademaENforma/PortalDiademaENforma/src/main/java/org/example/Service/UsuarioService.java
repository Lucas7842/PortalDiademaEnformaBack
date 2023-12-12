package org.example.Service;


import lombok.RequiredArgsConstructor;
import org.example.Entity.Usuario;
import org.example.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("#### USUARIO NÃO ENCONTRADO ####")
        );
    }

    @Transactional
    public Usuario editarSenha(long id, String password) {
        Usuario user = buscarPorId(id);
        user.setSenha(password);
        return user;
    }

    @Transactional
    public Usuario deletarUsuario(long id){
        Usuario user = buscarPorId(id);
      usuarioRepository.delete(user);
      return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}