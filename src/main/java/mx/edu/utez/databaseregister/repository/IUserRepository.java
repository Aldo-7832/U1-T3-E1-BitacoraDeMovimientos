package mx.edu.utez.databaseregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import mx.edu.utez.databaseregister.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Procedure(name = "User.registerLogin")
    User registerLogin(@Param("idUser") long idUser);

    @Query(value = "SELECT u FROM User u WHERE u.username = :userName AND u.pass = :pass")
    public User userLogin(@Param("userName") String userName, @Param("pass") String pass);

}