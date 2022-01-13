package edu.anushka.spring.poc;

//import lombok.Data;
import javax.persistence.*;

@Entity
// @Table(name = "employee")
public class Employee {

 @Id
 // @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "id", nullable = false)
 private Integer id;

 // @Column(name = "first_Name", nullable = false)
 private String firstName;

// @Column(name = "last_Name", nullable = false)
 private String lastName;

// @Column(name = "salary", nullable = true)
 private Integer salary;

 private String dept;

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public Integer getSalary() {
  return salary;
 }

 public void setSalary(Integer salary) {
  this.salary = salary;
 }


 public String getDept() {
  return dept;
 }

 public void setDept(String dept) {
  this.dept = dept;
 }
}
