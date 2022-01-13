package edu.anushka.spring.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// https://spring.io/guides/tutorials/rest/

//CRUD
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // create = insert
    @PostMapping
    public ResponseEntity<String> add(@RequestBody Employee emp) {
        System.out.println("Add employee :: name: " + emp.getFirstName() + " " + emp.getLastName());
        // Save emp in database
        employeeRepository.save(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    // Read == select
    @GetMapping("/{id}")
    public ResponseEntity<List<Employee>> get(@PathVariable Integer id) {

        List<Employee> employees = new ArrayList<>();
        System.out.println("Read employee :: id: " + id);


        // Read emp from database
        if (id == null || id <= 0) {
            Iterable<Employee> iterable = employeeRepository.findAll();
            iterable.forEach(employees::add);

        } else {
            Employee emp = null;
            Optional<Employee> result = employeeRepository.findById(id);
            if (result.isPresent()) {
                emp = result.get();

                if (emp != null) {
                    System.out.println("Read employee :: name: " + emp.getFirstName() + " " + emp.getLastName());
                    employees.add(emp);
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee with id " + id + " not found");
                }
            }
        }

//        Employee emp = new Employee();
//        emp.setFirstName("Anushka");
//        emp.setId(id);
//        emp.setLastName("Mahamulkar");
//        emp.setSalary(800);
        System.out.println("Read employee :: employees.size()= " + employees.size());

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    // Update
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Employee emp) {
        System.out.println("Update employee :: name: " + emp.getFirstName() + " " + emp.getLastName());

        // Update emp in database
        HttpStatus httpStatus = null;
        if (employeeRepository.existsById(emp.getId())) {
            //If an existing resource is modified, either the 200 (OK) or 204 (No Content ) response codes SHOULD be sent to indicate successful completion of the request.
            httpStatus = HttpStatus.NO_CONTENT;
            employeeRepository.save(emp);
        } else {
            //If a new resource has been created by the PUT API, the origin server MUST inform the user agent via the HTTP response code 201 (Created) response.
            // httpStatus = HttpStatus.CREATED;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee with id " + emp.getId() + " not found");
        }

        return ResponseEntity.status(httpStatus).body(null);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        System.out.println("Delete employee :: id: " + id);

        // Delete emp from database
        HttpStatus httpStatus = null;
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            httpStatus = HttpStatus.NO_CONTENT;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee with id " + id + " not found");
        }

        return ResponseEntity.status(httpStatus).body(null);
    }

}
