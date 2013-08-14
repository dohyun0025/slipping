package net.slipp.dao.contents;

import java.util.ArrayList;

import net.slipp.domain.content.Content;
import net.slipp.support.AbstractDaoSupport;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("contentDao")
public class SpringJdbcContentDao extends AbstractDaoSupport implements ContentDao {
	
	RowMapper<Content> rowMapper= ContentRowMapperFactory.getRowMapper();

	public void insert(Content content) {
		String sql = "select top(1) * from contents Order By index desc;";
		/*
		 * return very last ID 
		 * FROM TABLE(CONTENTS)
		 */
		Content c = DataAccessUtils.uniqueResult(getJdbcTemplate().query(sql, rowMapper));
		content.setIndex(c.getIndex()+1);
		
		sql = "INSERT INTO CONTENTS VALUES (?, ?, ?, now(), ?)";
		getJdbcTemplate().update(sql, content.getIndex(), content.getSubject(), content.getNote(), content.getOwner());
	}

	public Content findByID(String index) {
		String sql = "SELECT index, subject, note, time, owner FROM CONTENTS where index=? ORDER BY time DESC ";
		return DataAccessUtils.uniqueResult(getJdbcTemplate().query(sql, rowMapper, index));
	}
	
	public ArrayList<Content> getContents() {
		String sql = "SELECT index, subject, note, time, owner FROM CONTENTS C ORDER BY time DESC, index DESC";
		return (ArrayList<Content>)getJdbcTemplate().query(sql, rowMapper);
	}

	@Override
	public void update(String index, Content content) {
		String sql = "UPDATE CONTENTS set subject=?, note=? where index=?";
		getJdbcTemplate().update(sql,content.getSubject(),content.getNote(),content.getIndex());
	}
}

