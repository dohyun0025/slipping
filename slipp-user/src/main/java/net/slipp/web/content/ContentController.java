package net.slipp.web.content;

import javax.servlet.http.HttpSession;

import net.slipp.domain.content.Content;
import net.slipp.service.content.ContentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contents")
public class ContentController {
	ContentService cs = new ContentService();
	
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
	public String create(Content content){
		System.out.println(content.getSubject());
		cs.insert(content);
		return "redirect:contents/list";
	}
	
	@RequestMapping(value="{index}/form", method = RequestMethod.POST)
	public String updateForm(Content content){
		System.out.println(content.getSubject());
		cs.insert(content);
		return "contents/form";
	}
	
	@RequestMapping(value="/{index}", method = RequestMethod.POST)
	public String update(Content content){
		System.out.println(content.getSubject());
		cs.insert(content);
		return "redirect:contents/list";
	}

	
	//@RequestMapping(value = "", method = RequestMethod.POST)

}
