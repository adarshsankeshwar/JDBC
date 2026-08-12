package com.kodnest.jdbcProblems;

import java.util.Objects;

public class Student {

    int id;
    String name;
    String gender;
    int age;
    String collage;
    String university;
    int tenthM;
    int twelthM;
    int degree;
    Address address;

    public Student() {
        super();
    }

    public Student(int id, String name, String gender, int age,
            String collage, String university, int tenthM,
            int twelthM, int degree, Address address) {

        super();

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.collage = collage;
        this.university = university;
        this.tenthM = tenthM;
        this.twelthM = twelthM;
        this.degree = degree;
        this.address = address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getTenthM() {
        return tenthM;
    }

    public void setTenthM(int tenthM) {
        this.tenthM = tenthM;
    }

    public int getTwelthM() {
        return twelthM;
    }

    public void setTwelthM(int twelthM) {
        this.twelthM = twelthM;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, age, collage, degree, gender,
                id, name, tenthM, twelthM, university);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Student other = (Student) obj;

        return Objects.equals(address, other.address)
                && age == other.age
                && Objects.equals(collage, other.collage)
                && degree == other.degree
                && Objects.equals(gender, other.gender)
                && id == other.id
                && Objects.equals(name, other.name)
                && tenthM == other.tenthM
                && twelthM == other.twelthM
                && Objects.equals(university, other.university);
    }

    @Override
    public String toString() {
        return "Student [id=" + id
                + ", name=" + name
                + ", gender=" + gender
                + ", age=" + age
                + ", collage=" + collage
                + ", university=" + university
                + ", tenthM=" + tenthM
                + ", twelthM=" + twelthM
                + ", degree=" + degree
                + ", address=" + address + "]";
    }
}