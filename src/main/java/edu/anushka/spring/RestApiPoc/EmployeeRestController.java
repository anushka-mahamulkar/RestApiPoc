package edu.anushka.spring.RestApiPoc;

import org.springframework.web.bind.annotation.*;

//CRUD
@RestController
@RequestMapping ("/employee")
public class EmployeeRestController {
    

    // create = insert
    @PostMapping
    public String add(Employee emp) {
        System.out.println("Add employee :: name: " + emp.getFirstName() +" "+emp.getLastName());
        return "Added employee successfully";
    }

    // Read == select
    @GetMapping
    public Employee get(@RequestParam("id") Integer id) {
        
        Employee emp = new Employee();
        emp.setFirstName("Anushka");
        emp.setId(id);
        emp.setLastName("Mahamulkar");
        emp.setSalary(800);

        System.out.println("Read employee :: name: " + emp.getFirstName() +" "+emp.getLastName());

        return emp;
    }

    // Update
    @PutMapping
    public String update(Employee emp) {
        System.out.println("Update employee :: name: " + emp.getFirstName() +" "+emp.getLastName());

        return "Hello World";
    }

    // Delete
    @DeleteMapping
    public String delete(Employee emp) {
        System.out.println("Delete employee :: name: " + emp.getFirstName() +" "+emp.getLastName());

        return "Hello World";
    }

}
