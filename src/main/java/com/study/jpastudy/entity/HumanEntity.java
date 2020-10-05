package com.study.jpastudy.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "human")
public class HumanEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long _id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "AGE",nullable = false)
    private int age;
    @Column(name = "MONEY",nullable = false)
    private int money;
}
