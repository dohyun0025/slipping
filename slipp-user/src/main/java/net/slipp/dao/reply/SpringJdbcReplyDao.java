package net.slipp.dao.reply;

import java.util.ArrayList;

import net.slipp.domain.reply.Reply;
import net.slipp.domain.user.User;
import net.slipp.support.AbstractDaoSupport;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("replyDao")
public class SpringJdbcReplyDao extends AbstractDaoSupport implements ReplyDao{
	private RowMapper<Reply> rowMapper = ReplyRowMapperFactory.getRowMapper();
	
	public void insert(String index, String reply, User user) {
		String sql = "SELECT top(1) * from REPLYS ORDER BY ID DESC";
		/*
		 * return very last ID 
		 * FROM TABLE(REPLYS)
		 */
		int id = Integer.parseInt(DataAccessUtils.uniqueResult(getJdbcTemplate().query(sql, rowMapper)).getId())+1;
		
		sql = "INSERT INTO REPLYS VALUES(?,?,?,now(),?)";
		getJdbcTemplate().update(sql, id, Integer.parseInt(index),reply,user.getUserId());
	}
	
	public ArrayList<Reply> getReply(String index) {		
		String sql = "SELECT * FROM REPLYS WHERE INDEX=? ORDER BY time DESC, id DESC";
		return (ArrayList<Reply>)getJdbcTemplate().query(sql, rowMapper,Integer.parseInt(index));
	}
	
	public void delete(String id) {
		String sql = "delete from replys where id = ?";
		getJdbcTemplate().update(sql,Integer.parseInt(id));
	}
}
