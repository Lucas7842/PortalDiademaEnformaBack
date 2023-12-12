package org.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name = "empresas")
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "empresa", nullable = false, length = 200)
    private String empresa;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 200)
    private String senha;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 200)
    private String telefone;

    @Column(name = "endereco", nullable = false, length = 200, columnDefinition = "TEXT")
    private String endereco;

    @Column(name = "profissional", nullable = false, length = 200)
    private String profissional;

    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;


    public enum Role {
        ROLE_ADMIN, ROLE_CLIENTE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                '}';
    }
}



