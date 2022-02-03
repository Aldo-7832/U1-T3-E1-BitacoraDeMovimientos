package mx.edu.utez.databaseregister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.databaseregister.repository.ICommitsRepository;
import mx.edu.utez.databaseregister.entity.Commits;

@Service
public class CommitsService {
    @Autowired
    private ICommitsRepository commitsRepository;

    public List<Commits> findAll() {
        return commitsRepository.findAll();
    }

    public Commits save(Commits commits) {
        boolean res = false;
        Commits obj = commitsRepository.save(commits);

        if (!obj.equals(null)) {
            res = true;
        }
        return obj;
    }

}
