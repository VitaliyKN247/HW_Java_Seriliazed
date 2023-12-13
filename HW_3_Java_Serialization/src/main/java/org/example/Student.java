package org.example;

import java.io.Serializable;

public class Student implements Serializable {

    public Student(String name, Integer age, Double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    //region Гетеры и Сетеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    //endregion

    //region Поля
    private String name;
    private Integer age;
    private transient Double GPA;



    //endregion
}
