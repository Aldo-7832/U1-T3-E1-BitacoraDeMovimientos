package mx.edu.utez.databaseregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.edu.utez.databaseregister.entity.LastLogin;
import mx.edu.utez.databaseregister.entity.User;

public interface ILastLoginRepository extends JpaRepository<LastLogin, Long> {

    @Query(value = "SELECT p FROM User p WHERE p.username = :username AND p.pass = :pass")
    User loginSession(@Param("username") String username, @Param("pass") String pass);
}
