//package ru.webapp.webapp01.model;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.*;
//
//@Entity
//@DynamicInsert
//@DynamicUpdate
//@Table(name = "cars")
//public class Car {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "model")
//    private String model;
//
//    @Column(name = "mark")
//    private String mark;
//
//    @Column(name = "year")
//    private Long year;
//
//    public Car(){}
//
//    public Car(String model, String mark, Long year){
//        this.model = model;
//        this.mark = mark;
//        this.year = year;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public String getMark() {
//        return mark;
//    }
//
//    public void setMark(String mark) {
//        this.mark = mark;
//    }
//
//    public Long getYear() {
//        return year;
//    }
//
//    public void setYear(Long year) {
//        this.year = year;
//    }
//}
