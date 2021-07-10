package com.duscas.example.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Person {
    private @Id String cpf;
    private String name;
    private int age;
    private double salary;
    private int course;
    private String role;

    public Person() {
    }

    public Person(String cpf, String name, int age, int course, String role) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.course = course;
        this.role = role;
    }

    public Person(String cpf, String name, int age, double salary, String role) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.role = role;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", course=" + course +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(person.salary, salary) == 0 && course == person.course && cpf.equals(person.cpf) && name.equals(person.name) && role.equals(person.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, age, salary, course, role);
    }
}
