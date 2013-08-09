package net.slipp.dao.contents;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import net.slipp.domain.content.Content;

@Repository("JdbcContentDao") 
public class JdbcContentDao implements ContentDao {
	private static ArrayList<Content> contentArray = new ArrayList<Content>();

	public void insert(Content content) {
	}
	public Content findByID(String index) {
		return null;
	}
	public ArrayList<Content> getContents() {
		return null;
	}
	@Override
	public void addReply(String index, String reply) {
		// TODO Auto-generated method stub
		
	}
	

}
