package net.home.jdbc.dao.entiti;

import java.math.BigDecimal;

public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public Developer() {
    }

    public Developer(Long id, String firstName, String lastName, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Long getId(Long id) {
        return id;
    }

    public void setId(Long id) {
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

    public Developer withId(Long id) {
        this.id = id;
        return this;
    }

    public Developer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Developer withLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Developer withSalary(BigDecimal salary){
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
