package com.example.experiment05.practise;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {
    private int id;
    private String detail;

    public Address(int id, String detail) {
        this.id = id;
        this.detail = detail;
    }
}
