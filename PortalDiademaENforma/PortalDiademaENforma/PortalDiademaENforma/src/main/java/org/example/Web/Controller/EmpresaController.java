package org.example.Web.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Entity.Empresa;
import org.example.Service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
        Empresa user = empresaService.salvar(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Long id){
        Empresa user = empresaService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }
    @PatchMapping("/{id}")
    public  ResponseEntity<Empresa> updatePassword(@PathVariable long id, @RequestBody Empresa empresa){
        Empresa user = empresaService.editarSenha(id, empresa.getSenha() );
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> delete(@PathVariable long id){
        Empresa user = empresaService.deletarEmpresa(id);
        return  ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<List<Empresa>>getAll(){
        List<Empresa> users = empresaService.buscarTodos();
        return ResponseEntity.ok(users);
    }

}

