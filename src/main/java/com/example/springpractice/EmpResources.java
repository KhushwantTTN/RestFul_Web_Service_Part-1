package com.example.springpractice;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmpResources {

    private EmpDaoService service;

    public EmpResources(EmpDaoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }
    @GetMapping("/employee")
    public List<Employee> retriveAll(){
        return service.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee retriveOne(@PathVariable int id){
        Employee employee =  service.findOne(id);
        if(employee == null){
            throw new EmpNotFoundException("id :"+ id);
        }

        return employee;
    }


    @DeleteMapping("/employee/{id}")
    public void deleteOne(@PathVariable int id){
        service.deleteById(id);
    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> createUser(@Valid @RequestBody Employee employee){
        Employee savedEmp = service.saveUser(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmp.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable int id, @Valid @RequestBody Employee employee) {
        employee.setId(id);
        service.updateEmployee(employee);
    }


}
