package net.slipp.dao.contents;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import net.slipp.domain.content.Content;

@Repository("memoryContentDao") 
public class MemoryContentDao implements ContentDao {
	private static ArrayList<Content> contentArray = new ArrayList<Content>();

	public void insert(Content content) {
		content.nextIndex();
		contentArray.add(content);
	}

	public Content findByID(String index) {
		return contentArray.get(Integer.parseInt(index)-1);
	}

	public ArrayList<Content> getContents() {
		return contentArray;
	}

	@Override
	public void addReply(String index, String reply) {
		Content content = contentArray.get(Integer.parseInt(index)-1);
		
	}

}
