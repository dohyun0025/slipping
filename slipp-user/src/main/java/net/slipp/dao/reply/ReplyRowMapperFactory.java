package net.slipp.dao.reply;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.slipp.domain.reply.Reply;

import org.springframework.jdbc.core.RowMapper;

public class ReplyRowMapperFactory {
	public static RowMapper<Reply> getRowMapper(){
		RowMapper<Reply> rowMapper = new RowMapper<Reply>(){
			@Override
			public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Reply(
						rs.getInt("id"), 
						rs.getInt("index"),
						rs.getString("reply"),
						rs.getString("time"),
						rs.getString("owner")
						);
			}
		};
		return rowMapper;
	}
}
