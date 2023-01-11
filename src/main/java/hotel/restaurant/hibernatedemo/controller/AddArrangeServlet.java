package hotel.restaurant.hibernatedemo.controller;


import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.restaurant.dao.RestaurantDao;
import hotel.restaurant.dao.RestaurantDaoImpl;
import hotel.restaurant.hibernatedemo.model.Arrange;

@Controller
public class AddArrangeServlet{
	@Autowired
	private RestaurantDao dao ;	

	@PostMapping("/AddArrangeServlet")
	protected String addArrange(@RequestParam("arrangename")@Nullable String name, @RequestParam("arrangepeople")@Nullable String people,
			@RequestParam("restaurantid")@Nullable String id, @RequestParam("arrangephone")@Nullable String phone,
			@RequestParam("arrangeday")@Nullable String day, @RequestParam("eattime")@Nullable String eattime, Model m) {

		String name2 = name;
		String phone2 = phone;
		String day2 = day;
		String eattime2 = eattime;
		String error = "不能輸入空白";

		if (name == "") {
			m.addAttribute("nullError2", error);
			
			return "/Restaurant/AddArrange";
		}
		if (phone == "") {
			m.addAttribute("nullError3", error);
			
			return "/Restaurant/AddArrange";
		}
		if (people == "") {
			m.addAttribute("nullError4", error);
		
			return "/Restaurant/AddArrange";
		}
		if (day == "") {
			m.addAttribute("nullError5", error);
			
			return "/Restaurant/AddArrange";
		}

		if (id == "") {
			m.addAttribute("nullError7", error);
			
			return "/Restaurant/AddArrange";
		}
		int check = Integer.parseInt(id);

		boolean checkResult = dao.checkRes(check);

		if (checkResult == true) {
			m.addAttribute("nullError10", "沒有這家餐廳");
			
			return "/Restaurant/AddArrange";
		}

		int people2 = Integer.parseInt(people);
		int resid = Integer.parseInt(id);
		System.out.println(resid);
		Arrange ArrBean = new Arrange(name2, phone2, people2, day2, eattime2, resid);
//		dao2.selectAll();
		dao.AddArrange(ArrBean);
		m.addAttribute("success", 1);
		
		return "/Restaurant/AddRestaurant";

	}
}
