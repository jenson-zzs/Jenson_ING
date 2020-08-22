package com.zzs.demo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.zzs.demo.DO.User;

@Mapper
public interface UserDao {
	
//	 @ResultMap("BaseResultMap")
	 @Select(value = {"select * from User where account= #{account} and pwd=#{pwd}"})
	 public User getUser(@Param("account") String account, @Param("pwd") String pwd);
	 
	 @Insert(value = { " insert into User( account,pwd)  values( #{account},#{pwd})" })
	 public int insert(User user); 
	 
//	 @Results(id="userMap", value={
//				@Result(column="id", property="id", id=true),
//			    @Result(column="user_name", property="userName"),
//			    @Result(column="user_password ", property="userPassword"),
//			    @Result(column="user_email", property="userEmail"),
//			    @Result(column="user_info", property="userInfo"),
//			    @Result(column="head_img", property="headImg", jdbcType=JdbcType.BLOB),
//			    @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
//		})
//	 public List<User> insertBatch(@Param("list") List<User> list);
	 
}
