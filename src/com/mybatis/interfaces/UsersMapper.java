 package com.mybatis.interfaces;

import java.util.List;
import java.util.Map;

import com.mybatis.model.Article;
import com.mybatis.model.Users;
 public interface UsersMapper {

	 //方法名必须与Users.xml中的select id="selectUsersByID"一致
	 public Users selectUsersByID(int id);
	 
	 public List<Users> selectUsers(String userName);
	 
	 public List<Users> selectUsers(List<String> list);
	 
	 public List<Users> selectUsers2(String[] str);
	 
	 public List<Users> selectUsers3(Map<String, Object> map);
	 
	 public void addUsers(Users users);
	 
	 public void updateUsers(Users users);
	 
	 public void deleteUsers(int id);
	 
	 public List<Article> getUsersArticles(int userid);
}

 