package com.travel.agency.protsiv.model;

import lombok.*;


@Data
@Builder
//@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Model {

    private Integer id;
    private String login;
    private String name;
    private String email;
    private Integer age;
    private String role;


//    public User(String login,
//                String email,
//                Integer age,
//                String role) {
//        this.login = login;
//        this.email = email;
//        this.age = age;
//        this.role = role;
//    }

}
