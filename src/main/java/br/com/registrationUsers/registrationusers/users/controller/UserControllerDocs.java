package br.com.registrationUsers.registrationusers.users.controller;

import br.com.registrationUsers.registrationusers.users.dto.UserDTO;
import br.com.registrationUsers.registrationusers.users.dto.UserResponseDTO;
import br.com.registrationUsers.registrationusers.users.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Cadastro de Usuários")
public interface UserControllerDocs {

    @ApiOperation(value = "Criação de usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuário criado com sucesso"),
            @ApiResponse(code = 400, message = "Campos faltando, valores informados divergentes ou o usuário já está cadastrado")
    })
    UserResponseDTO create(UserDTO userToCreateDTO);

    @ApiOperation(value = "Atualizar o usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Campos faltando, valores informados divergentes ou o usuário não está cadastrado"),
            @ApiResponse(code = 404, message = "Usuário não encontrado com esse ID!")
    })
    UserResponseDTO update(Long id, UserDTO userToUpdateDTO);

    @ApiOperation(value = "Busca de Usuario pelo Nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário encontrado com sucesso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado")
    })
    User findByName(String nome);

    @ApiOperation(value = "Lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os usuários")
    })
    List<UserDTO> findAll();

    @ApiOperation(value = "Exclusão de Usuario pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Usuário excluido com sucesso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado com esse ID!")
    })
    public void delete(Long id);
}
