package com.study.qdgxy.mapper;

import com.study.qdgxy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface UserMapper {

    User findUserByName(@Param("username") String username);
}
