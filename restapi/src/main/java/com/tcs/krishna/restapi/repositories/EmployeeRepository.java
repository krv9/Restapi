package com.tcs.krishna.restapi.repositories;

import com.tcs.krishna.restapi.entities.EmployeeEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntities,Long> {
}
