package com.github.UlrikeWerner.Stream;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int postalCode;
    private int age;

    public Student(String studentData) {
        String[] student = studentData.split(",");
        this.id = Integer.parseInt(student[0]);
        this.name = student[1];
        this.postalCode = Integer.parseInt(student[2]);
        this.age = Integer.parseInt(student[3]);
    }

    public Student(int id, String name, int postalCode, int age) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && postalCode == student.postalCode && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, postalCode, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postalCode=" + postalCode +
                ", age=" + age +
                '}';
    }
}
