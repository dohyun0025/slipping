package net.slipp.domain.reply;

import net.slipp.domain.user.User;

public class Reply {
	private String id;
	private String index;
	private String reply;
	private String userId;
	private String time;
	
	public Reply(String index, String reply, User user) {
		this.index = index;
		this.reply = reply;
		this.userId = user.getUserId();
	}
	public Reply(int id, int index, String reply, String time,
			String userId) {
		this.id=id+"";
		this.index=index+"";
		this.reply=reply;
		this.time=time;
		this.userId=userId;
		
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIndex(){
		return index;
	}
}
