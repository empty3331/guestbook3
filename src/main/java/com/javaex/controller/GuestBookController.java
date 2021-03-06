package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping("/guest")
public class GuestBookController {
	
	@Autowired
	GuestBookDao gbDao;
	
	@RequestMapping("/addlist" )
	public String addList(Model model) {
		System.out.println("addlist");
		
		
		List<GuestBookVo> gbList = gbDao.getGuestBookList();
		
		
		model.addAttribute("gbList",gbList);
		
		return "addList";
	}
	
	@RequestMapping("/add" )
	public String add(@ModelAttribute GuestBookVo gbVo) {
		System.out.println("add");
		
		
		gbDao.guestBookInsert(gbVo);
		
		System.out.println(gbVo.toString());
		
		return "redirect:/guest/addlist";
	}
	
	@RequestMapping("/deleteForm" )
	public String deleteForm(Model model,@RequestParam("no") int no) {
		System.out.println("deleteForm");
	
		model.addAttribute("no", no);
	
		return "deleteForm";
	}
	

	@RequestMapping("/delete" )
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String password) {
		
        gbDao.guestBookDelete(no, password);
		
		return "redirect:/guest/addlist";
				
	}


}
