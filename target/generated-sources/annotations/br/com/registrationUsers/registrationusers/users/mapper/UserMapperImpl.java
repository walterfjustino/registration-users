package br.com.registrationUsers.registrationusers.users.mapper;

import br.com.registrationUsers.registrationusers.users.dto.UserDTO;
import br.com.registrationUsers.registrationusers.users.dto.UserResponseDTO;
import br.com.registrationUsers.registrationusers.users.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-26T14:15:35-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toModel(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setNome( userDTO.getNome() );
        user.setSobrenome( userDTO.getSobrenome() );
        user.setDataNascimento( userDTO.getDataNascimento() );
        user.setTelefone( userDTO.getTelefone() );

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setNome( user.getNome() );
        userDTO.setSobrenome( user.getSobrenome() );
        userDTO.setDataNascimento( user.getDataNascimento() );
        userDTO.setTelefone( user.getTelefone() );

        return userDTO;
    }

    @Override
    public UserResponseDTO toResponseModel(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setNome( user.getNome() );
        userResponseDTO.setSobrenome( user.getSobrenome() );
        userResponseDTO.setDataNascimento( user.getDataNascimento() );
        userResponseDTO.setTelefone( user.getTelefone() );

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO toResponseDTO(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setNome( userDTO.getNome() );
        userResponseDTO.setSobrenome( userDTO.getSobrenome() );
        userResponseDTO.setDataNascimento( userDTO.getDataNascimento() );
        userResponseDTO.setTelefone( userDTO.getTelefone() );

        return userResponseDTO;
    }
}
