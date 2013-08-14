package net.slipp.dao.contents;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.slipp.domain.content.Content;

import org.springframework.jdbc.core.RowMapper;

public class ContentRowMapperFactory {
	public static RowMapper<Content> getRowMapper(){
		RowMapper<Content> rowMapper = new RowMapper<Content> () {
			@Override
			public Content mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Content(
						rs.getInt("index"), 
						rs.getString("subject"), 
						rs.getString("note"),
						rs.getString("time"),
						rs.getString("owner")
						);
			}
		};
		return rowMapper;
	}
}
