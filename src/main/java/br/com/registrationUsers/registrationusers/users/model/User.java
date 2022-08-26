package br.com.registrationUsers.registrationusers.users.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/aaaa")
    @Column
    private String dataNascimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(00)000000000")
    @Column
    private String telefone;
}
