package mx.edu.utez.databaseregister.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.edu.utez.databaseregister.entity.Commits;

public interface ICommitsRepository extends JpaRepository<Commits, Long> {
    List<Commits> findAllByOrderByIdDesc();
}
