package org.example.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Entity.Usuario;
import org.example.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }
    @PatchMapping ("/{id}")
    public  ResponseEntity<Usuario> updatePassword(@PathVariable long id, @RequestBody Usuario usuario){
        Usuario user = usuarioService.editarSenha(id, usuario.getSenha() );
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable long id){
        Usuario user = usuarioService.deletarUsuario(id);
        return  ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<Usuario>>getAll(){
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(users);
    }

}
