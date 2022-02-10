package mx.edu.utez.databaseregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.databaseregister.entity.LoginDTO;
import mx.edu.utez.databaseregister.entity.User;
import mx.edu.utez.databaseregister.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public User userLogin(@RequestBody LoginDTO obj) {
        try{
            User tmp = userService.userLogin(obj.getUserName(), obj.getPass());
            userService.updateUserLogin(tmp.getId());
            return userService.userLogin(obj.getUserName(), obj.getPass());
        } catch (Exception e) {
            return null;
        }
    }
}
