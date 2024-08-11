package com.UKG.IJP.Services;

import com.UKG.IJP.Exceptions.EmployeeExceptions;
import com.UKG.IJP.Model.EmployeeModel;
import com.UKG.IJP.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository emprepo1;

    public List<EmployeeModel> getAllEmployees(){
        if(emprepo1.findAll().size()==0){
            throw new EmployeeExceptions("List is empty");
        }
        return emprepo1.findAll();
    }

    public EmployeeModel getEmployeebyID(@PathVariable("id") long id){
        Optional<EmployeeModel> getEmployee = emprepo1.findById(id);
        if(getEmployee.isEmpty()){
            throw new EmployeeExceptions("No Employee exist");
        }
        return getEmployee.get();
    }

    public EmployeeModel addEmployee(EmployeeModel emp){
        if(emprepo1.findById(emp.getEmpID()).isPresent()){
            throw  new EmployeeExceptions("id already used");
        }
        return emprepo1.save(emp);
    }

}
