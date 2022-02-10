package mx.edu.utez.databaseregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.databaseregister.entity.User;
import mx.edu.utez.databaseregister.repository.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public User userLogin(String userName, String pass) {
        return userRepository.userLogin(userName, pass);
    }

    public User updateUserLogin(long id) {
        return userRepository.registerLogin(id);
    }
    
}
