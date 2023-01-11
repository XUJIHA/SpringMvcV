package hotel.restaurant.hibernatedemo.controller;



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
public class RewriteArrangeServerlet {
	@Autowired
	RestaurantDao dao ;

	@PostMapping("/RewriteArrangeServerlet")
	protected String rewriteArr(@RequestParam("arrangename")@Nullable String name, @RequestParam("people")@Nullable String people,
			@RequestParam("restaurantid")@Nullable String id, @RequestParam("arrangephone")@Nullable String phone,
			@RequestParam("day")@Nullable String day, @RequestParam("eattime")@Nullable String eattime,@RequestParam("arrangenumber")@Nullable String number, Model m) {

		System.out.println(123);

		String name2 = name;
		String phone2 = phone;

		String day2 = day;
		String eattime2 = eattime;

		String error = "不能輸入空白";
		if (number == "") {
			m.addAttribute("nullError", error);
			
			return "/Restaurant/RewriteArrange";
		}
		if (name == "") {
			m.addAttribute("nullError2", error);
			
			return "/Restaurant/RewriteArrange";
		}
		if (phone == "") {
			m.addAttribute("nullError3", error);
			
			return "/Restaurant/RewriteArrange";
		}
		if (people == "") {
			m.addAttribute("nullError4", error);
			
			return "/Restaurant/RewriteArrange";
		}
		if (day == "") {
			m.addAttribute("nullError5", error);
			
			return "/Restaurant/RewriteArrange";
		}
		int id2 = Integer.parseInt(number);
		boolean checkRes = dao.checkArr(id2);
		if (checkRes == true) {
			m.addAttribute("nullError9", "訂單編號不存在");
			
			return "/Restaurant/RewriteArrange";
		}


		int number2 = Integer.parseInt(number);
		int people2 = Integer.parseInt(people);
		int restaurantid = Integer.parseInt(id);
		Arrange ArrBean = new Arrange(number2, name2, phone2, people2, day2, eattime2, restaurantid);
		dao.RewriteArrange(ArrBean);
		m.addAttribute("success", 1);
		
		return "/Restaurant/RewriteArrange";

	}
}
