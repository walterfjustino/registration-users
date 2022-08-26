package br.com.registrationUsers.registrationusers.users.service;

import br.com.registrationUsers.registrationusers.users.dto.UserDTO;
import br.com.registrationUsers.registrationusers.users.dto.UserResponseDTO;
import br.com.registrationUsers.registrationusers.users.model.User;

import java.util.List;

public interface UserService {

    UserResponseDTO create(UserDTO userToCreateDTO);

    UserResponseDTO update(Long id, UserDTO userToUpdateDTO);

    User findByName(String nome);

    List<UserDTO> findAll();

    public void delete(Long id);
}
