package com.empsCrud.EmployeeCRUD.Exception;

import java.util.NoSuchElementException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

     @ExceptionHandler(EntityNotFoundException.class)
     public ModelAndView handleEmployeeNotFoundException(EntityNotFoundException ex, Model model) {
          ModelAndView modelAndView = new ModelAndView("PageNotFound");
          model.addAttribute("message", "The employee you are looking for does not exist.");
          modelAndView.addObject("errorMessage", ex.getMessage());
          return modelAndView;
     }

     @ExceptionHandler(NoSuchElementException.class)
     public ModelAndView handleElementNotFoundException(NoSuchElementException ex, Model model) {
          ModelAndView modelAndView = new ModelAndView("PageNotFound");
          model.addAttribute("message", "The Employee you are looking for does not exist.");
          modelAndView.addObject("errorMessage", ex.getMessage());
          return modelAndView;
     }

     @ExceptionHandler(Exception.class)
     public ModelAndView handleGenericException(Exception ex, Model model) {
          ModelAndView modelAndView = new ModelAndView("PageNotFound");
          model.addAttribute("message", "Something went wrong! Please try again later.");
          modelAndView.addObject("errorMessage", ex.getMessage());
          return modelAndView;
     }
}
