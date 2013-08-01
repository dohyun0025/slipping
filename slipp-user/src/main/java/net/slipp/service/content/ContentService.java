package net.slipp.service.content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import net.slipp.dao.contents.ContentDAO;
import net.slipp.domain.content.Content;

public class ContentService {
	public ContentService(){
		ContentDAO.initData();
	}
//	public Map<String, Content> getContents(){
//		ContentDAO cd = new ContentDAO();
//		return cd.getContents();
//	}
	public ArrayList<Content> getContents(){
		ContentDAO cd = new ContentDAO();
		
		/*
		 * 이 코드는 hashMap 을 쓸경우 순차적으로 저장이 안되어서
		 * 게시글들은 ArrayList에 저장을 하고 
		 * 저장을 하였을떄 출력순서는 오래된-> 새로운 순서라서
		 * 마지막 포인터부터 새로운 어레이리스트 에 저장하여 
		 * 새로운 어레이리스트를 리턴  
		 */
		ArrayList<Content> arrayList = cd.getContents();
		ArrayList<Content> arrayListAfter = new ArrayList<Content>();
		ListIterator it = arrayList.listIterator();
		
		while(it.hasNext()){
			it.next();
		}
		while(it.hasPrevious()){
			arrayListAfter.add((Content)it.previous());
		}
		return arrayListAfter;
	}
	
	public void insert(Content content) {
		ContentDAO cd = new ContentDAO();
		
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String str = dayTime.format(new Date(time));
		content.setTime(str);
		
		cd.insert(content);
	}
	public Content findByID(String index) {
		ContentDAO cd = new ContentDAO();
		
		return cd.findByID(index);
		
	}
}
