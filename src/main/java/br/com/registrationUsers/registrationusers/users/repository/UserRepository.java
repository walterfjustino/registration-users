package br.com.registrationUsers.registrationusers.users.repository;

import br.com.registrationUsers.registrationusers.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByNomeAndSobrenome(String nome, String Sobrenome);
    @Query(value = "SELECT * FROM usuario WHERE nome LIKE ? ORDER BY nome, sobrenome", nativeQuery = true)
    Optional<User> findByNomeOrderByNome(String nome);
}
