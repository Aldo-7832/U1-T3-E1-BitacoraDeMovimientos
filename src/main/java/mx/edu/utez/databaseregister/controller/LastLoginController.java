package mx.edu.utez.databaseregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.databaseregister.service.LastLoginService;
import mx.edu.utez.databaseregister.entity.LastLogin;
import mx.edu.utez.databaseregister.entity.User;

@RestController
@RequestMapping(path = "/lastLogin")
public class LastLoginController {
    
    @Autowired
    private LastLoginService lastLoginService;

    @GetMapping()
    public List<LastLogin> findAlly() {
        return lastLoginService.findAll();
    }

    @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
    public LastLogin save(@RequestBody LastLogin obj) {
        try {
            return lastLoginService.save(obj);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(value = "/login/{username}/{pass}")
    public User login(@PathVariable String username, @PathVariable String pass) {
        return lastLoginService.login(username, pass);
    }

    @PostMapping(value = "/procedure/{id}")
    public boolean procedimiento(@PathVariable int id) {
        try{
            return lastLoginService.procedimiento(id);
        }catch(Exception e){
            return true;
        }
    }
}
