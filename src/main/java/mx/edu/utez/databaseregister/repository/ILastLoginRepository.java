package mx.edu.utez.databaseregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.utez.databaseregister.entity.LastLogin;

public interface ILastLoginRepository extends JpaRepository<LastLogin, Long> {
    
}
