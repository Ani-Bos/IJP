package com.UKG.IJP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class EmployeeModel {
    @Id
    @GeneratedValue
    private long EmpID;
    private String EmpName;
    private String EmpEmail;
    private String Role;
    private Boolean isAdmin;
    private String DateOfJoining;
}
