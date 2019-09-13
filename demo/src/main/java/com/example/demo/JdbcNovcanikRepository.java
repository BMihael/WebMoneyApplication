package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
/*
@Repository
*/
public class JdbcNovcanikRepository{

	/// implements NovcanikRepository 
	
	
/*
	private final JdbcTemplate jdbc;
	private final SimpleJdbcInsert novcanikInsert;
	
	public JdbcNovcanikRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		this.novcanikInsert = new SimpleJdbcInsert(jdbc)
				.withTableName("Novcanik")
				.usingGeneratedKeyColumns("id");
	}
	
	@Override
	public Iterable<Novcanik> findAll() {
		return jdbc.query("select * from novcanik",this::mapRowToNovcanik);
		
	}

	@Override
	public Novcanik findOne(Long id) {
		return jdbc.queryForObject("select * from novcanik where id = ?", this::mapRowToNovcanik,id);
	}
	
	@Override
	public Novcanik findOne(String username) {
		return jdbc.queryForObject("select * from novcanik where user = ?", this::mapRowToNovcanik,username);
	}

	@Override
	public Novcanik save(Novcanik novcanik) {
		novcanik.setCreateDate(LocalDateTime.now());
		novcanik.setId(saveNovcanikDetails(novcanik));
		return novcanik;
	}
	
	
	private long saveNovcanikDetails(Novcanik novcanik) {
		Map<String,Object> vrijednosti = new HashMap<>();
		vrijednosti.put("datumUpisa", novcanik.getCreateDate());
		vrijednosti.put("nazivNovcanika", novcanik.getNazivNovcanika());
		vrijednosti.put("tip", novcanik.getTip());
		vrijednosti.put("user", novcanik.getUser());
		
		return novcanikInsert.executeAndReturnKey(vrijednosti).longValue();
	}
	
	private Novcanik mapRowToNovcanik(ResultSet st, int rowNum) throws SQLException {
		Novcanik novcanik = new Novcanik();
		novcanik.setId(st.getLong("id"));
		novcanik.setCreateDate(st.getTimestamp("datumUpisa").toLocalDateTime());
		novcanik.setNazivNovcanika(st.getString("nazivNovcanika"));
		novcanik.setTip(Novcanik.Tip.valueOf(st.getString("tip")));
		novcanik.setUser(st.getString("user"));
		
		return novcanik;
	}

	@Override
	public Iterable<Novcanik> findAll(String username) {
		return jdbc.query("select * from novcanik where user = ?",this::mapRowToNovcanik,username);
	}

	@Override
	public void delete(Long id) {
		///tu mozda treba dovrsiti
	}

	@Override
	public void update(Long id, Novcanik novcanik) {
		// TODO Auto-generated method stub
		
	}
	
*/
}
