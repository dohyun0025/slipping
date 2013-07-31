package net.slipp.service.content;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import net.slipp.dao.contents.ContentDAO;
import net.slipp.domain.content.Content;

public class ContentService {
	public ContentService(){
		ContentDAO.initData();
	}
	public Map<String, Content> getContents(){
		ContentDAO cd = new ContentDAO();
		return cd.getContents();
	}
	public void insert(Content content) {
		ContentDAO cd = new ContentDAO();
		
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String str = dayTime.format(new Date(time));
		content.setTime(str);
		
		System.out.println(str);
		
		cd.insert(content);
	}
}
