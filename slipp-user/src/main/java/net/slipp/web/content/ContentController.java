package net.slipp.web.content;

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
@RequestMapping("/contents")
public class ContentController {
	@Autowired
	ContentService cs;	
	@Autowired
	ReplyService rs;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		model.addAttribute("contents",cs.getContents());
		return "content/content";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String createForm(Model model){
		model.addAttribute("content",new Content());
		return "content/form";
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public String create(Content content, HttpSession session){
		User user = (User)session.getAttribute("loginUser");
		cs.insert(content, user);
		return "redirect:contents/list";
	}
	
	@RequestMapping(value="/{index}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable String index, Content content, Model model, HttpSession session) throws OwnerNotEqualException{
		Content c = cs.findByID(index);
		
		User user = (User)session.getAttribute("loginUser");
		try{
			if((c.getOwner().equals(user.getUserId()))==false){	
				throw new OwnerNotEqualException();
			}
		}catch (OwnerNotEqualException e){
			model.addAttribute("errorMessage","업데이트 권한없음 Error");
			return "content/error";
		}
		model.addAttribute("content", c);
		model.addAttribute("forwardPage","update");
		
		return "content/form";
	}

	@RequestMapping(value="/{index}", method = RequestMethod.POST)
	public String update(@PathVariable String index, Content content, HttpSession session){
		Content preContent = cs.findByID(index);
		preContent.update(content);
		
		return "redirect:/contents/list";
	}
	@RequestMapping(value="/{index}", method = RequestMethod.GET)
	public String show(@PathVariable String index, Model model){
		Content c = cs.findByID(index);
		model.addAttribute("content", c);
		model.addAttribute("replys", rs.getReply(index));
		
		return "content/show";
	}
	
	
	//@RequestMapping(value = "", method = RequestMethod.POST)

}
