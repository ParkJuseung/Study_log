package com.test.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
public class AddressDTO {

    private String seq;
    private String name;
    private String age;
    private String address;
    private String gender;

}
