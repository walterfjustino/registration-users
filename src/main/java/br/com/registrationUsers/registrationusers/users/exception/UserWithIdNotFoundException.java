package br.com.registrationUsers.registrationusers.users.exception;

import javax.persistence.EntityExistsException;

public class UserWithIdNotFoundException extends EntityExistsException {

    public UserWithIdNotFoundException(Long id) {
        super(String.format("Usuário com esse id: %s não encontrado!", id));
    }
}
