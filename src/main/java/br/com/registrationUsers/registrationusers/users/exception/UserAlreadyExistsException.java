package br.com.registrationUsers.registrationusers.users.exception;

import javax.persistence.EntityExistsException;

public class UserAlreadyExistsException extends EntityExistsException {
    public UserAlreadyExistsException(String nome, String sobrenome) {
        super(String.format("Usuário com esse nome: %s já existe!", nome + " " + sobrenome));
    }
}
