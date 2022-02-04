package mx.edu.utez.databaseregister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.databaseregister.repository.ILastLoginRepository;
import mx.edu.utez.databaseregister.entity.LastLogin;

@Service
public class LastLoginService {
    @Autowired
    private ILastLoginRepository lastLoginRepository;

    public List<LastLogin> findAll() {
        return lastLoginRepository.findAll();
    }

    public LastLogin save(LastLogin lastLogin) {
        boolean res = false;
        LastLogin obj = lastLoginRepository.save(lastLogin);

        if (!obj.equals(null)) {
            res = true;
        }
        return obj;
    }

}
