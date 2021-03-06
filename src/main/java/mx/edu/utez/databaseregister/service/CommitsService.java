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

    public boolean saveCommit(Commits obj) {
        boolean flag = false;
        if(obj.getTable().equals("1")){
            obj.setTable("product");
        }
        Commits tmp = commitsRepository.save(obj);
        if(tmp != null) {
            flag = true;
        }
        return flag;
    }

    public List<Commits> findByOrderByIdDesc() {
        return commitsRepository.findAllByOrderByIdDesc();
    }

}
