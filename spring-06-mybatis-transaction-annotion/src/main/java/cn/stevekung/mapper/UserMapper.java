package cn.stevekung.mapper;

import cn.stevekung.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserMapper {
    // CRUD
    @Select("select * from user")
    public List<User> getUsers();

    @Select("select * from user where id = #{id}")
    public User getUserById(@Param("id") Long id);

    @Insert("insert into user (name) values(#{name})")
    public void addUser(User user);

    @Update("update user set name = #{name} where id = #{id}")
    public int updateUser(User user);

    @Delete(("delete from user where id =#{id}"))
    public int deleteUser(Long id);
}
