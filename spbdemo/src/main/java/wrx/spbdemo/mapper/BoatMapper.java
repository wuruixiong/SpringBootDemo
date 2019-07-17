package wrx.spbdemo.mapper;

import org.apache.ibatis.annotations.*;
import wrx.spbdemo.bean.Boat;
import wrx.spbdemo.bean.User;

import java.util.List;

@Mapper
//@Repository
public interface BoatMapper {

    @Select("select * from boat")
    List<Boat> selectAll();

    @Select("select * from user where name = #{name}")
    List<Boat> selectUserByName(String name);

    @Insert("insert boat (uid, name, method, head, body) values(#{uid}, #{name}, #{method}, #{head}, #{body})")
    void addOne(Boat boat);

    @Delete("delete from user where uid = #{uid} and bid = #{bid}")
    void deleteOne(Boat boat);

}
