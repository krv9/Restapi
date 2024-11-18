package com.tcs.krishna.restapi.services;

import com.tcs.krishna.restapi.dto.EmployeeDTO;
import com.tcs.krishna.restapi.entities.EmployeeEntities;
import com.tcs.krishna.restapi.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeId(Long id){
        EmployeeEntities employeeEntities=employeeRepository.getById(id);
    return modelMapper.map(employeeEntities,EmployeeDTO.class);
    }

    public EmployeeDTO create(EmployeeDTO employeeDTO) {

        EmployeeEntities employeeEntities = modelMapper.map(employeeDTO,EmployeeEntities.class);
        return modelMapper.map(employeeRepository.save(employeeEntities),EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeEntities -> modelMapper.map(employeeEntities,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteEmployeebyid(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent)return false;
        employeeRepository.deleteById(id);
        return true;
    }
}
