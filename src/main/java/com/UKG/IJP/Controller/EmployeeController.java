package com.UKG.IJP.Controller;

import com.UKG.IJP.Exceptions.EmployeeExceptions;
import com.UKG.IJP.Model.EmployeeModel;
import com.UKG.IJP.Repository.EmployeeRepository;
import com.UKG.IJP.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository emprepo1;
    @Autowired
    private EmployeeService empservice;
  @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees(){
        try{
            return new ResponseEntity<List<EmployeeModel>>(empservice. getAllEmployees(), HttpStatus.CREATED);
        }
        catch(EmployeeExceptions e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
  @GetMapping(path="/{id}")
    public ResponseEntity<EmployeeModel> getEmployeebyID(@RequestParam("id") long id){
      try{
          return new ResponseEntity<>(empservice.getEmployeebyID(id),HttpStatus.CREATED);
      }
      catch (EmployeeExceptions e){
          return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
      }
  }
  @PostMapping(path="/addEmployee")
    public ResponseEntity<EmployeeModel>addEmployee(EmployeeModel emp){
      try{
          return new ResponseEntity<>(empservice.addEmployee(emp),HttpStatus.CREATED);
      }
      catch(EmployeeExceptions e) {
          return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
      }
  }
}
