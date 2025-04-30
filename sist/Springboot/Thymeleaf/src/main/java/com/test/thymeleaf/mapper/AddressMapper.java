package com.test.thymeleaf.mapper;

import com.test.thymeleaf.dto.AddressDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    String time();

    int count();

    String getName(int i);

    AddressDTO get(int i);

    List<String> names();

    List<AddressDTO> list();
}
