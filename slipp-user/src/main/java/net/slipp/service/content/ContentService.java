package net.slipp.service.content;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.slipp.dao.contents.ContentDao;
import net.slipp.domain.content.Content;
import net.slipp.domain.user.User;

@Service
public class ContentService {
	@Resource(name="contentDao")
	ContentDao contentDao;
	
	public ArrayList<Content> getContents(){
		return contentDao.getContents();
	}
	
	public void insert(Content content,User user) {		
		content.setOwner(user.getUserId());
		contentDao.insert(content);
	}
	public Content findByID(String index) {		
		return contentDao.findByID(index);
	}

	public void update(String index, Content content) {
		contentDao.update(index, content);		
	}

}
