package com.empsCrud.EmployeeCRUD.Repo;

import com.empsCrud.EmployeeCRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
     
}
