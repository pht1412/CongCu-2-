package com.example.LeHongPhat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String skill;

    public Cv(){}

    public Long getId(){ return id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone = phone; }

    public String getSkill(){ return skill; }
    public void setSkill(String skill){ this.skill = skill; }
}
