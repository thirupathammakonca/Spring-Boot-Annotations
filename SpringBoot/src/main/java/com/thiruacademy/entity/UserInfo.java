package com.thiruacademy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_userinfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    //@NotNull(message="Username name should not be null")
	//@NotEmpty(message="Username name should not be empty")
    //private String username;
    //@NotNull(message="Password name should not be null")
	//@NotEmpty(message="Password name should not be empty")
    //private String password;
    //private String roles;
    private String uname;
	private String pwd;
	private String role;
}
