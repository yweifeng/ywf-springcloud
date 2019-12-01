package com.ywf.mapper;

import com.ywf.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:ywf
 */
@Mapper
public interface UserMapper {

    void insertUser(User u);
}
