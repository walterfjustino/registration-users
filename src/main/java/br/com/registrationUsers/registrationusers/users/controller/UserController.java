package br.com.registrationUsers.registrationusers.users.controller;

import br.com.registrationUsers.registrationusers.users.dto.UserDTO;
import br.com.registrationUsers.registrationusers.users.dto.UserResponseDTO;
import br.com.registrationUsers.registrationusers.users.model.User;
import br.com.registrationUsers.registrationusers.users.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController implements UserControllerDocs{

    @Autowired
    private UserServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public UserResponseDTO create(@RequestBody @Valid UserDTO userToCreateDTO) {
        return service.create(userToCreateDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public UserResponseDTO update(@PathVariable Long id, @RequestBody @Valid UserDTO userToUpdateDTO) {
        return service.update(id, userToUpdateDTO);
    }


    @GetMapping("/{nome}")
    @Override
    public User findByName(@PathVariable String nome) {
        return service.findByName(nome);
    }

    @GetMapping
    @Override
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
