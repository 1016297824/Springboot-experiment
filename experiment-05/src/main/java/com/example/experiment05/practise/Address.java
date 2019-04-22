package com.example.experiment05.practise;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Address {
    private int id;
    private String detail;
    private String comment;
    private LocalDateTime insertTime;

    public Address(int id, String detail) {
        this.id = id;
        this.detail = detail;
    }
}
