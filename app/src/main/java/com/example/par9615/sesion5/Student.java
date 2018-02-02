package com.example.par9615.sesion5;

/**
 * Created by par9615 on 31/01/18.
 */

public class Student {
    private String name, phone, education, sex, book;
    private Boolean sport;

    public Student(String name, String phone, String education, String sex, String book, Boolean sport) {
        this.name = name;
        this.phone = phone;
        this.education = education;
        this.sex = sex;
        this.book = book;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Boolean getSport() {
        return sport;
    }

    public void setSport(Boolean sport) {
        this.sport = sport;
    }

    public String toString() {
        String data =   "Nombre: " + this.name + "\n" +
                        "Teléfono: " + this.phone + "\n" +
                        "Escolaridad: " + this.education + "\n" +
                        "Género: " + this.sex + "\n" +
                        "Libro Favorito: " + this.book + "\n" +
                        "Practica Deporte: " + (this.sport? "Si" : "No");
        return data;
    }
}
