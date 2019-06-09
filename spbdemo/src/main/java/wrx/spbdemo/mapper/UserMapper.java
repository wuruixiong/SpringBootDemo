package wrx.spbdemo.mapper;

import org.apache.ibatis.annotations.*;
import wrx.spbdemo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> selectAll();

    @Select("select name, email from user")
    List<User> selectAllUser();

    @Select("select * from user where name = #{name} and password = #{password}")
    List<User> selectUserByNamePwd(User user);

    @Select("select * from user where uid = #{uid}")
    List<User> selectUserByUid(Integer uid);

    @Select("select * from user where name = #{name}")
    List<User> selectUserByName(String name);

    @Insert("insert user (name, password, email) values(#{name}, #{password}, #{email})")
    void addOne(User user);

    @Update("update user set name = #{name} where uid = #{uid} and password = #{password}")
    void updateName(User user);

    @Delete("delete from user where uid = #{uid} and name = #{name} and password = #{password}")
    void deleteOne(User user);

}
