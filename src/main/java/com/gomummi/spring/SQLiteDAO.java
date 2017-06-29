package com.gomummi.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component("sqliteDAO")
public class SQLiteDAO implements MP3DAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(MP3 mp3) {
		final String sql = "insert into mp3 (name, author) VALUES (?, ?)";
		
		//anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		//jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä. 
		final String name = mp3.getName();
		final String author = mp3.getAuthor();
		
		//jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		// jdbcTemplate.update(sql, new Object[] { mp3.getName(), mp3.getAuthor() });
		
		//suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla ja KeyHolderilla
				jdbcTemplate.update(
			    	    new PreparedStatementCreator() {
			    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
			    	            ps.setString(1, name);
			    	            ps.setString(2, author);
			    	           
			    	            return ps;
			    	        }
			    	    }, idHolder);
			    
			    mp3.setId(idHolder.getKey().intValue());

	}

	// Sama metodi perus JDBC:llä
	public void insertWithJDBC(MP3 mp3) {

		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:db/SpringDB.db";
			conn = DriverManager.getConnection(url, "", "");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into mp3 (name, author) VALUES (?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mp3.getName());
			ps.setString(2, mp3.getAuthor());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void delete(int id) {

		String sql = "DELETE FROM mp3 WHERE id=?";
		int result = jdbcTemplate.update(sql, id);

	}

	@Override
	public void delete(MP3 mp3) {

		delete(mp3.getId());

	}
	
	@Override
	public List<MP3> getAll() {	
		
		String sql = "select id, name, author from mp3";
		RowMapper<MP3> mapper = new MP3RowMapper();
		List<MP3> mp3 = jdbcTemplate.query(sql,mapper);

		return mp3;
	}
	

	 public MP3 find(int id) {
	 String sql = "select name, author, id from mp3 where id = ?";
	 Object[] parameters = new Object[] { id };
	 RowMapper<MP3> mapper = new MP3RowMapper();
	
	 MP3 mp3;
	 try {
			mp3 = jdbcTemplate.queryForObject(sql, parameters, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new MP3notFind(e);
			}
			
	 	return mp3;
	 }

	@Override
	public MP3 getMP3ByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MP3> getMP3ListByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MP3> getMP3ListByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
