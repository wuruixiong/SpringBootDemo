package wrx.spbdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wrx.spbdemo.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> selectAll();

    @Select("select name, email from user")
    List<User> selectAllUser();

}
