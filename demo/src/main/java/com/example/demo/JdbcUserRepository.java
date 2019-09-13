package com.example.demo;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/*
@Repository
*/
public class JdbcUserRepository {

	////implements UserRepository
	
	/*
	private final JdbcTemplate jdbc;
	private final SimpleJdbcInsert userInsert;
	
	public JdbcUserRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		this.userInsert = new SimpleJdbcInsert(jdbc)
				.withTableName("Users");
	}

	@Override
	public Iterable<User> findAll() {
		return jdbc.query("select * from users",this::mapRowToUser);
	}

	@Override
	public User save(User user) {
		saveUserDetails(user);

		return user;
	}

	private void saveUserDetails(User user) {
		Map<String,Object> vrijednosti = new HashMap<>();
		vrijednosti.put("username",user.getUsername());
		vrijednosti.put("password",user.getPassword());
		vrijednosti.put("enableBit",user.getEnabledBit());
	
		userInsert.execute(vrijednosti);
	}
	

	private User mapRowToUser(ResultSet st, int rowNum) throws SQLException {
		User user = new User();
		
		user.setUsername(st.getString("username"));
		user.setPassword(st.getString("password"));
		user.setEnabledBit(Integer.valueOf(st.getString("enableBit")));
		
		return user;
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String username,User userNew, User user) {
		// TODO Auto-generated method stub
		
	}
	*/
}
