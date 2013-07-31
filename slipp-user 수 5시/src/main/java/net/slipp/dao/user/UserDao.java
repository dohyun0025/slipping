package net.slipp.dao.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.slipp.domain.user.User;

public class UserDao {
	private static Map<String, User> users = new HashMap<String, User>();
	
	public void insert(User user) {
		users.put(user.getUserId(), user);
	}

	public User findByUserId(String userId) throws SQLException {
		return users.get(userId);
	}
	
	public static int numberOfUser(){
		return users.size();
	}

	public static void initData() {
		UserDao ud = new UserDao();
		if (numberOfUser()==0){
			ud.insert(new User("dohyun0025","3470mi","정도현","c3098051@sds.co.kr"));
			ud.insert(new User("c3098051","3470mi","정도현","c3098051@sds.co.kr"));
		}		
		
	}
}