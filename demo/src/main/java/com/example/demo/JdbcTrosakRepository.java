package com.example.demo;

import  com.example.demo.Trosak;
import com.example.demo.Trosak.Vrsta;

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
public class JdbcTrosakRepository {

	////implements TrosakRepository
	
	/*
	private final JdbcTemplate jdbc;
	private final SimpleJdbcInsert trosakInsert;
	
	public JdbcTrosakRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		this.trosakInsert = new SimpleJdbcInsert(jdbc)
				.withTableName("Trosak")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public Iterable<Trosak> findAll() {
		return jdbc.query("select * from trosak",this::mapRowToTrosak);
		
	}
	
	
	@Override
	public Trosak findOne(Long id) {
		return jdbc.queryForObject("select * from trosak where id = ?", this::mapRowToTrosak,id);
	}
	
	@Override
	public Trosak findOne(String id) {
		return jdbc.queryForObject("select * from trosak where id = ?", this::mapRowToTrosak,id);
	}
	
	

	
	@Override
	public Trosak save(Trosak trosak) {
		trosak.setCreateDate(LocalDateTime.now());
		trosak.setId(saveTrosakDetails(trosak));
		
		return trosak;
	}
	
	@Override
	public void delete(Long id) {
		String SQL = "delete from trosak where id = ?";
		jdbc.update(SQL,id);
	}
	
	
	
	private long saveTrosakDetails(Trosak trosak) {
		Map<String,Object> vrijednosti = new HashMap<>();
		vrijednosti.put("naziv", trosak.getNaziv());
		vrijednosti.put("datumUpisa", trosak.getCreateDate());
		vrijednosti.put("iznos", trosak.getIznos());
		vrijednosti.put("vrsta", trosak.getVrsta());
		vrijednosti.put("id_novcanik", trosak.getNovcanik());
		return trosakInsert.executeAndReturnKey(vrijednosti).longValue();
	}
	
	private Trosak mapRowToTrosak(ResultSet st, int rowNum) throws SQLException {
		Trosak trosak = new Trosak();
		trosak.setId(st.getLong("id"));
		trosak.setCreateDate(st.getTimestamp("datumUpisa").toLocalDateTime());
		trosak.setIznos(st.getInt("iznos"));
		trosak.setNaziv(st.getString("naziv"));
		trosak.setVrsta(Trosak.Vrsta.valueOf(st.getString("vrsta")));
		///trosak.setNovcanik(st.getLong("id_novcanik"));
		
		return trosak;
	}

	@Override
	public int count() {
		String SQL = "select count(*) from trosak where iznos > ?";
		int num=0;
		num=jdbc.queryForObject(
				SQL, new Object[] { "2000" }, Integer.class);
		return num;
	}

	@Override
	public void deleteByIdNovcanik(Long id) {
		String SQL = "delete from trosak where id_novcanik = ?";
		jdbc.update(SQL,id);
		
	}

	@Override
	public void update(Long id,Novcanik novcanik, Trosak trosak) {
		// TODO Auto-generated method stub
		
	}

	

*/
	
}
