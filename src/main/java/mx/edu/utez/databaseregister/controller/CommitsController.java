package mx.edu.utez.databaseregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.databaseregister.service.CommitsService;
import mx.edu.utez.databaseregister.entity.Commits;

@RestController
@RequestMapping(path = "/commits")
public class CommitsController {
    
    @Autowired
    private CommitsService commitsService;

    @GetMapping()
    public List<Commits> findAll() {
        return commitsService.findByOrderByIdDesc();
    }

    @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
    //@Transactional
    public boolean saveCommit(@RequestBody Commits obj) {
        try {
            return commitsService.saveCommit(obj);
        } catch (Exception e) {
            return false;
        }
    }

}
