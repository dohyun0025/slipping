package net.slipp.dao.contents;


import java.util.ArrayList;

import net.slipp.domain.content.Content;

public interface ContentDao {
	void insert(Content content);
	Content findByID(String index);
	ArrayList<Content> getContents();
	void update(String index, Content content);

}
