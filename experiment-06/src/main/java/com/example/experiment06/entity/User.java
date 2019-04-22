package com.example.experiment06.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    @Size(min = 2, max = 4, message = "您输入的用户名为：${validatedValue}，长度必须在{main}~{max}之间。")
    private String userName;
    @Size(min = 7,message = "密码必须大于{min}")
    private String password;
    @Min(value = 18,message = "您的年龄必须大于{value}")
    @Max(value = 60,message = "您的年龄必须小于{value}")
    private int age;
    @Email
    private String email;
}
