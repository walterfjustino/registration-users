package br.com.registrationUsers.registrationusers.users.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "Informar o nome do usuario")
    @Size(max = 200, message = "maximo de 200 caracteres permitido para o nome")
    private String nome;

    @NotBlank(message = "Informar o sobrenome do usuario")
    @Size(max = 200, message = "maximo de 200 caracteres permitido para o sobrenome")
    private String sobrenome;


    @NotBlank(message = "Informar a data de nascimento do usuario")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/aaaa")
    @Pattern(regexp =  "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])", message = "preencher data no formato: dd/MM/aaaa")
    @Size(max = 10, min = 10, message = "preencher data no formato: dd/MM/aaaa")
    private String dataNascimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(00)000000000")
    @NotBlank(message = "Informar um telefone de contato")
    @Size(max = 13, min = 13, message = "número de telefone necessário preencher 11 caracteres, no formato: (00)000000000 ")
    private String telefone;
}
