package net.slipp.dao.contents;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.slipp.domain.content.Content;

public class ContentDAO {
	private static Map<String, Content> contents = new HashMap<String, Content>();
	
	public static int numberOfContent() {
		// TODO Auto-generated method stub
		return contents.size();
	}
	public static void initData(){
		if(numberOfContent()==0){
			ContentDAO cd = new ContentDAO();
			cd.insert(new Content("test1","내용입니다","2012-10-13"));
			cd.insert(new Content("test2","내용입니다2","2012-10-15"));
		}
	}
	public void insert(Content content) {
		contents.put(content.getIndex()+"", content);
		contents.values();
	}

	public Map<String, Content> getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

}
