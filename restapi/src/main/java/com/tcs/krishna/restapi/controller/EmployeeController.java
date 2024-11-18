package com.tcs.krishna.restapi.controller;


import com.tcs.krishna.restapi.dto.EmployeeDTO;
import com.tcs.krishna.restapi.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
//    @GetMapping(path = "/employees")
//    public String getEmployees(){
//        return "Hello World";
//    }
//    @GetMapping(path = "/employees")
//    public EmployeeDTO getEmployees(){
//        return new EmployeeDTO(12l,"krishna", LocalDate.of(2024,12,2),true);
//    }



    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployebyid(@PathVariable Long id){
        return employeeService.deleteEmployeebyid(id);
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long EmployeeID){
    return  employeeService.getEmployeeId(EmployeeID);
    }
    @PostMapping
    public EmployeeDTO getData(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.create(employeeDTO);
    }
}

