package com.empsCrud.EmployeeCRUD.Controller;

import com.empsCrud.EmployeeCRUD.Entity.Employee;
import com.empsCrud.EmployeeCRUD.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    // Employee Services for all the CRUD operations
    @Autowired
    private EmployeeService employeeService;

    // displays all the employees that are available in database
    @GetMapping("/employees")
    public String displayAll(Model model) {
        List<Employee> emp = employeeService.findAll();
        model.addAttribute("employees", emp);
        return "displayEmployee"; // HTML template that displays the list of employees in tabular format
    }

    // Display Employee By There ID
    // Here Exception will occur that must be fixed in exception folder
    // the exception will accour if employee of given id is not found that is
    // EMPLOYEENOTFOUND EXCEPTION
    @GetMapping("/displayById")
    public String displayEmpById(@RequestParam("id") Integer id, Model model) {
        Optional<Employee> emp = employeeService.findById(id);
        if (emp != null) {
            model.addAttribute("employees", emp.get());
        } 
        return "displayEmployee";

    }

    // Displaying form for adding the new Employee
    @GetMapping("/formToAddEmployee")
    public String displayForm() {

        return "addEmpForm";
    }

    // // Adds new Employee
    @PostMapping("/employee")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/emp/employees";
    }

    // First shows the form with previous values and after submiting new it is
    // updated in database
    // So this Controller shows form to update and also update in database
    @GetMapping("/formToUpdateEmployee")
    public String updateEmployeeForm(@RequestParam("id") Integer id, Model model,
            RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } 
        return "updateEmpForm";

    }

    // // deletes Employee By Id
    @DeleteMapping("/deleteEmployee/{empId}")
    public String deleteEmployee(@PathVariable Integer empId, Model model) {
        Optional<Employee> employee = employeeService.findById(empId);
        if (employee.isPresent()) {
            employeeService.deleteById(empId);

        }
        return "redirect:/emp/employees";
    }

    // Fetches employee to delete it because browser directly does not support
    // DELETE Mapping so with this controller, it fetches the employee of given id
    // and calls the function of delete mapping.
    @GetMapping("/fetchEmployee")
    public String fetchEmployee(@RequestParam("id") Integer id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {

            return deleteEmployee(id, model);
        } else {

            return "redirect:/emp/employees";
        }
    }
}
