package net.slipp.service.reply;

import javax.annotation.Resource;

import net.slipp.dao.reply.ReplyDao;
import net.slipp.domain.user.User;

import org.springframework.stereotype.Service;


@Service
public class ReplyService {
	@Resource(name="replyDao")
	ReplyDao replyDao;

	public void insert(String index, String reply, User user) {
		replyDao.insert(index, reply, user);		
	}

	public Object getReply(String index) {
		return replyDao.getReply(index);
	}

	public void delete(String id) {
		replyDao.delete(id);
	}
}
