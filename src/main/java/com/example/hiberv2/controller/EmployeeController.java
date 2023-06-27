package com.example.hiberv2.controller;

import com.example.hiberv2.model.Details;
import com.example.hiberv2.model.Employee;
import com.example.hiberv2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService serviceE;
    @PostMapping
    public void createOnlyEmployee(@RequestBody Employee employee) {
        serviceE.addingEmployee(employee);
    }
    @PostMapping("/and")
    public void createEmployeeAndDetails(@RequestBody Employee employee,
                                         @RequestBody Details details){
        serviceE.addingEmployeeAndDetails(employee, details);
    }
    @PutMapping("/{idE}/{idD}")
    public void updateEmployeeByIdDetails(@PathVariable(value = "idE") Integer idE,
                                          @PathVariable(value = "idD") Integer idD) {
        serviceE.updateEmployeeByIdDetails(idE, idD);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(serviceE.findById(id),HttpStatus.OK);
    }
}
