package org.j2gl.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.j2gl.mybatis.domain.User;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (id, user, email) " +
            "VALUES (#{id}, #{user}, #{email})")
    Integer insert(User user);

}
