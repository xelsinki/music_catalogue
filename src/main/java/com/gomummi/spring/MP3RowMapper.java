package com.gomummi.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MP3RowMapper implements RowMapper<MP3> {

		@Override
		public MP3 mapRow(ResultSet rs, int rowNum) throws SQLException {
			MP3 mp3 = new MP3();
			mp3.setId(rs.getInt("id"));
			mp3.setName(rs.getString("name"));
			mp3.setAuthor(rs.getString("author"));
			return mp3;
		}
}
