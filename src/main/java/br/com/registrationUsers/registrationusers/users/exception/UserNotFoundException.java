package br.com.registrationUsers.registrationusers.users.exception;

import javax.persistence.EntityExistsException;

public class UserNotFoundException extends EntityExistsException {
    public UserNotFoundException(String nome) {
        super(String.format("Usuário com esse nome: %s não encontrado!", nome));
    }
}
