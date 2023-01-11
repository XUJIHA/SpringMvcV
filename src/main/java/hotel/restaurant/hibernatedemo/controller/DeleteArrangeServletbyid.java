package hotel.restaurant.hibernatedemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.restaurant.dao.RestaurantDao;

@Controller
public class DeleteArrangeServletbyid  {

	@Autowired
	RestaurantDao dao;
	@PostMapping("/DeleteArrangeServletbyid")

	protected String deleteArr(@RequestParam("arrangenumber")@Nullable String number, Model m)  {
		String error = "不能輸入空白";
		if (number == "") {
			m.addAttribute("nullError", error);
			
			return "/Restaurant/DeleteArrange";
		}
		int id = Integer.parseInt(number);
		boolean checkRes = dao.checkArr(id);
		if (checkRes==true) {
			m.addAttribute("nullError9", "編號不存在");
			
			return "/Restaurant/DeleteArrange";
		}
		dao.DeleteArrange(id);
		m.addAttribute("success", 1);
		
		return "/Restaurant/DeleteArrange";
	

	}
}
