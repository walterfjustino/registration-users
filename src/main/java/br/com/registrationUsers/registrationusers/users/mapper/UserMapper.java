package br.com.registrationUsers.registrationusers.users.mapper;

import br.com.registrationUsers.registrationusers.users.dto.UserDTO;
import br.com.registrationUsers.registrationusers.users.dto.UserResponseDTO;
import br.com.registrationUsers.registrationusers.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);

    UserResponseDTO toResponseModel(User  user);

    UserResponseDTO toResponseDTO(UserDTO  userDTO);
}
