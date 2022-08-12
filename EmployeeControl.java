package com.example.w2flap1.Cantroller;

import com.example.w2flap1.Model.Aip;
import com.example.w2flap1.Model.Employee;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController

@RequestMapping("/aip/v1/auth")
public class EmployeeControl {
private ArrayList<Employee>listemployee=new ArrayList<>();





@GetMapping("/employe")
    public ResponseEntity getemployee(){

    return ResponseEntity.status(200).body(listemployee);
}


@PostMapping("/employe")

    public ResponseEntity addemployee (@RequestBody @Valid Employee employee, Errors errors) {
    if (errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();

    return ResponseEntity.status(400).body(new Aip(message, 400));
        }
       listemployee.add(employee);
          return ResponseEntity.status(201).body( new Aip ("........",201));
}



@PutMapping("/employee/{index}")

    public ResponseEntity updataemployee (@RequestBody @Valid Employee employee,@PathVariable int index,Errors errors){
    if(errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new Aip(message,400));
    }
    if(index>=listemployee.size()){
        return ResponseEntity.status(400).body(new Aip("Invalid index",400));
    }
    listemployee.set(index,employee);
    return ResponseEntity.status(201).body( new Aip("User updated !",201));
}


@DeleteMapping("/employee/{index}")
    public ResponseEntity deletemployee(@RequestBody int index ){

if (index>=listemployee.size()){
    return ResponseEntity.status(400).body(new Aip ("Invalid index",400));
}
         listemployee.remove(index);
      return ResponseEntity.status(200).body(new Aip("employee delet",200));

}
    @PostMapping("/anleave")
    public ResponseEntity getannualLeave(@RequestBody int id) {
//        if(errors.hasErrors()){
//            String message=errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(new Aip(message,400));


        for (int i = 0; i < listemployee.size(); i++) {
            Employee employee = listemployee.get(i);
                  employee.getId().equals(id); {
                if (employee.getOnleave()== true || employee.getAnnualLeave() == 0) {
                    return ResponseEntity.status(400).body(new Aip("bad"));

                }
                employee.setOnleave(true);
                employee.setAnnualLeave(employee.getAnnualLeave() - 1);
                return ResponseEntity.status(400).body(new Aip("Done"));

            }

        }

        return ResponseEntity.status(400).body(new Aip("Wrong ", 400));


    }

}














