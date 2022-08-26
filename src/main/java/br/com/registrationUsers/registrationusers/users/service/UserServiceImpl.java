package br.com.registrationUsers.registrationusers.users.service;

import br.com.registrationUsers.registrationusers.users.dto.UserDTO;
import br.com.registrationUsers.registrationusers.users.dto.UserResponseDTO;
import br.com.registrationUsers.registrationusers.users.exception.UserAlreadyExistsException;
import br.com.registrationUsers.registrationusers.users.exception.UserNotFoundException;
import br.com.registrationUsers.registrationusers.users.exception.UserWithIdNotFoundException;
import br.com.registrationUsers.registrationusers.users.mapper.UserMapper;
import br.com.registrationUsers.registrationusers.users.model.User;
import br.com.registrationUsers.registrationusers.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService{

    public static final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    private UserRepository repository;

    @Override
    public UserResponseDTO create(UserDTO userToCreateDTO) {
        verifyIfUserExists(userToCreateDTO.getNome(), userToCreateDTO.getSobrenome());
        var userToCreate = mapper.toModel(userToCreateDTO);
        var createdUser = repository.save(userToCreate);
        return mapper.toResponseModel(createdUser);
    }

    @Override
    public UserResponseDTO update(Long id, UserDTO userToUpdateDTO) {
        var foundUser = verifyIfUserExistsAndGet(id);
        userToUpdateDTO.setId(foundUser.getId());
        var userUpdate = mapper.toModel(userToUpdateDTO);
        var updatedUser = repository.save(userUpdate);
        return mapper.toResponseModel(updatedUser) ;
    }

    @Override
    public User findByName(String nome) {
        return repository.findByNomeOrderByNome(nome)
                .orElseThrow(()-> new UserNotFoundException(nome));
    }

    @Override
    public List<UserDTO> findAll() {
        return repository.findAll()
                .stream().map(mapper::toDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        verifyIfUserExistsAndGet(id);
        repository.deleteById(id);
    }

    private void verifyIfUserExists(String nome, String sobrenome) {
        repository.findByNomeAndSobrenome(nome, sobrenome)
                .ifPresent(user -> {throw new UserAlreadyExistsException(nome, sobrenome);});
    }
    private User verifyIfUserExistsAndGet(Long id) {
       return  repository.findById(id)
                .orElseThrow(() -> new UserWithIdNotFoundException(id));
    }
}
