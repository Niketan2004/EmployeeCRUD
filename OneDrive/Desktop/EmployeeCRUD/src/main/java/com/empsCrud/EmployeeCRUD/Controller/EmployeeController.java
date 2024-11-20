package com.empsCrud.EmployeeCRUD.Controller;

import com.empsCrud.EmployeeCRUD.Entity.Employee;
import com.empsCrud.EmployeeCRUD.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    // @Autowired
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // displays all the employees
    @GetMapping("/display")
    public String displayAll(Model model) {
        List<Employee> emp = employeeService.findAll();
        model.addAttribute("employees", emp);
        return "displayEmployee";
    }

    // Display Employee By There ID
    //Here Exception will occur that must be fixed in exception folder
    @GetMapping("/displayById")
    public String displayEmpById(@RequestParam("id") Integer id, Model model) {
        Optional<Employee> emp = employeeService.findById(id);
        if (emp != null) {
            model.addAttribute("employees", emp.get());
            
        }else {   
            model.addAttribute("employees", null);
            }
        return "displayEmployee";
    }
    // // Adds new Employee
    // @PostMapping("/employee")
    // public Employee addEmployee(@RequestBody Employee employee) {
    // return employeeService.save(employee);
    // }

    // // updates the employee
    // @PutMapping("/employee")
    // public Employee updateEmployee(@RequestBody Employee employee) {
    // return employeeService.save(employee);
    // }

    // // deletes Employee By Id
    // @DeleteMapping("/employee/{empId}")
    // public String deleteEmployee(@PathVariable Integer empId) {
    // employeeService.deleteById(empId);
    // return "Employee Deleted Successfully!";
    // }
}
