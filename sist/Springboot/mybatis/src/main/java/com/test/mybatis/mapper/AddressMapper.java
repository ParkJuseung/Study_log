package com.test.mybatis.mapper;

import com.test.mybatis.dto.AddressDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    String time();

    List<AddressDTO> list();
}
