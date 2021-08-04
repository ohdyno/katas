package com.example.springboot_helloworld.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Name {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    public String name;
    public String occupation;
}
