package net.slipp.domain.content;

public class Content {
	private static int number=0;//Map에서 유니크한 키넘버를 위한 변수 
	private int index;			//글의 번호 
	private String subject;     //제목 
	private String note;		//내용 
	private String time;		//시간 
	private String owner;
	
	public Content(){
	}
	public Content(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		this.index = number;
		this.subject = string;
		this.note = string2;
		this.time = string3;
	}
	public void nextIndex(){
		number++;
		setIndex(number);		
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
	public String getOwner(){
		return owner;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void update(Content updatedContent){
		this.subject = updatedContent.getSubject();
		this.note = updatedContent.getNote(); 
	}
}
