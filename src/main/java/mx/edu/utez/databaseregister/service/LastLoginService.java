package mx.edu.utez.databaseregister.service;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.databaseregister.repository.ILastLoginRepository;
import mx.edu.utez.databaseregister.entity.LastLogin;
import mx.edu.utez.databaseregister.entity.User;

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

    public User login(String username, String pass) {
        boolean res = false;
        User obj = lastLoginRepository.loginSession(username, pass);
        System.out.println("USER: " + obj.getUsername());
        if (!obj.equals(null)) {
            res = true;
        }
        return obj;
    }

    public boolean procedimiento(int id) {
        boolean res = false;
        Object obj = null;
        try{
            obj = lastLoginRepository.getTotalCarsByModelEntiy(id);
        }catch(Exception e){
            obj = "";
        }
        System.out.println("RESPUESTA: "+obj);
        if (!obj.equals(null)) {
            res = true;
        }
        return res;
    }

}
