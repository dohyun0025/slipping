package net.slipp.dao.reply;

import java.util.ArrayList;

import net.slipp.domain.reply.Reply;
import net.slipp.domain.user.User;

public interface ReplyDao {
	public void insert(String index, String reply, User user);
	public ArrayList<Reply> getReply(String index);
	public void delete(String id);
}
