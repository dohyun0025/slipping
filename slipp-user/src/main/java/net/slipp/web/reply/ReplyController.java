package net.slipp.web.reply;

import javax.servlet.http.HttpSession;

import net.slipp.domain.content.Content;
import net.slipp.domain.user.User;
import net.slipp.service.content.ContentService;
import net.slipp.service.content.OwnerNotEqualException;
import net.slipp.service.reply.ReplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/qnas")
public class ReplyController {
	
	@Autowired
	ReplyService rs;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(String reply, String index, HttpSession session) throws Exception {
		User user = (User)session.getAttribute("loginUser");
		
		rs.insert(index, reply, user);
		return "redirect:/contents/"+index;
	}
	
	@RequestMapping(value = "/delete/{id}/{index}", method = RequestMethod.GET)
	public String delete(@PathVariable String id,@PathVariable String index) throws Exception {
		rs.delete(id);
		System.out.println(id +"   "+index);
		return "redirect:/contents/"+index;
	}

}
