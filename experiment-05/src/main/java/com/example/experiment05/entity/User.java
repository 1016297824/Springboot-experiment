package com.example.experiment05.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String detail;

    public User(int id, String name, String password, String detail) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.detail = detail;
    }
}