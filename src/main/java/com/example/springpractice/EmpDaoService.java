package com.example.springpractice;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component

public class EmpDaoService {

    private static List<Employee> employees = new ArrayList<>();

    public static int userCount = 0;

    static {
        employees.add(new Employee(++userCount,"khushwant",23));
        employees.add(new Employee(++userCount,"Hema",21));
    }


    public List<Employee> findAll(){
        return employees;
    }

    public Employee findOne(int id){
        Predicate<? super Employee> predicate = employee -> employee.getId().equals(id);
        return employees.stream().filter(predicate).findFirst().orElse(null);
    }

    public Employee saveUser(Employee employee){
        employee.setId(++userCount);
        employees.add(employee);
        return employee;
    }

    public void deleteById(int id){
        Predicate<? super Employee> predicate = employee -> employee.getId().equals(id);
        employees.removeIf(predicate);
    }

    public void updateEmployee(Employee employee) {
        Employee emp = findOne(employee.getId());
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
    }
}
