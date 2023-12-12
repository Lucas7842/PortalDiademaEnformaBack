package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Entity.Empresa;
import org.springframework.stereotype.Service;
import org.example.repository.EmpresaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Transactional
    public Empresa salvar(Empresa empresa){

        return empresaRepository.save(empresa);
    }

    @Transactional(readOnly = true)
  public Empresa buscarPorId(Long id ){
        return empresaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("### Empresa não encontrada ###")
        );
    }

    @Transactional
    public Empresa editarSenha(long id, String password) {
        Empresa user = buscarPorId(id);
        user.setSenha(password);
        return user;
    }

    @Transactional
    public Empresa deletarEmpresa(long id){
        Empresa user = buscarPorId(id);
        empresaRepository.delete(user);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Empresa> buscarTodos() {
        return empresaRepository.findAll();
    }
}


