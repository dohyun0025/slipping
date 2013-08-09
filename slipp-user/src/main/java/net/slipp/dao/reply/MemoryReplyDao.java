package net.slipp.dao.reply;

import java.util.ArrayList;

import net.slipp.domain.content.Content;
import net.slipp.domain.reply.Reply;
import net.slipp.domain.user.User;

import org.springframework.stereotype.Repository;

@Repository("memoryQnaDao")
public class MemoryReplyDao implements ReplyDao{
	private static ArrayList<Reply> replyArray = new ArrayList<Reply>();
	public void insert(String index, String reply, User user) {
		Reply re = new Reply(index,reply,user);
		re.setId(replyArray.size()+1+"");
		replyArray.add(re);
	}
	public ArrayList<Reply> getReply(String index) {
		ArrayList<Reply> retArray = new ArrayList<Reply>();
		for(int i = 0; i<replyArray.size();i++){
			if(replyArray.get(i).getIndex().equals(index))
				retArray.add(replyArray.get(i));
		}
		return retArray;
	}
	public void delete(String id) {
		replyArray.remove(Integer.parseInt(id)-1);
	}
}
