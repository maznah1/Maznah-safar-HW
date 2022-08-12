package com.example.w2flap1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data

public class Employee {

    @NotNull(message="Id can't be null")
    @Size(min=2,max=10,message = "Id Very short ")
    private int  Id;

    @NotNull(message = "Name can’t be null")
    @Size(min = 4,max = 10,message =  "name must be more than 3 char and less than 10 char")
    private String name;


    @NotNull(message ="age null")
    @Size(min = 18,max = 25)
    private int age;


    @NotNull
    @AssertFalse(message = "must byfalse ")
    private boolean onleave;


    @NotNull
    @Past
    @PastOrPresent
    private int employeeYear;


    @NotNull(message = "annualLeave null")
    private int annualLeave;


}
