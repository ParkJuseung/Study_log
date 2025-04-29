package com.test.basic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class Student {

    private Long seq;
    private String name;
    private Integer age;
    private String address;
    private String gender;

}
