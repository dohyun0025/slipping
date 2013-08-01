package net.slipp.dao.contents;

import java.util.ArrayList;

import net.slipp.domain.content.Content;

public class ContentDAO {
	private static ArrayList<Content> contentArray = new ArrayList<Content>();
	
	public static int numberOfContent() {
		// TODO Auto-generated method stub
		return contentArray.size();
	}
	public static void initData(){
		if(numberOfContent()==0){
			ContentDAO cd = new ContentDAO();
			cd.insert(new Content("test1","내용입니다","2012-10-13 10:53:30"));
			cd.insert(new Content("test2","내용입니다2","2012-10-15 10:55:30"));
		}
	}
	public void insert(Content content) {
		content.nextIndex();
		contentArray.add(content);
	}

//	public Map<String, Content> getContents() {
//		// TODO Auto-generated method stub
//		return contents;
//	}
	public ArrayList<Content> getContents() {
		// TODO Auto-generated method stub
		return contentArray;
	}
	public Content findByID(String index) {
		return contentArray.get(Integer.parseInt(index)-1);
	}
	

}
