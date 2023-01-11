package hotel.restaurant.hibernatedemo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.restaurant.dao.RestaurantDao;
import hotel.restaurant.dao.RestaurantDaoImpl;
import hotel.restaurant.hibernatedemo.model.Restaurant;

@Controller
public class RewriteRestaurantServerlet {
	@Autowired
	private RestaurantDao dao ;

	@PostMapping("/RewriteRestaurantServerlet")
	protected String rewriteRes(@RequestParam("restaurantname")@Nullable String name, @RequestParam("restaurantdes")@Nullable String des,
			@RequestParam("restauranttype")@Nullable String type, @RequestParam("restaurantaddress")@Nullable String address,
			@RequestParam("restaurantphone")@Nullable String phone, @RequestParam("restaurantseat")@Nullable String seat,
			@RequestParam("restaurantprice")@Nullable String price,@RequestParam("restaurantid")@Nullable String id, Model m) {

		String error = "不能輸入空白";
		if (id == "") {
			m.addAttribute("nullError", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		if (name == "") {
			m.addAttribute("nullError2", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		if (des == "") {
			m.addAttribute("nullError3", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		if (type == "") {
			m.addAttribute("nullError4", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		if (price == "") {
			m.addAttribute("nullError5", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		if (address == "") {
			m.addAttribute("nullError6", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		if (phone == "") {
			m.addAttribute("nullError7", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		if (seat == "") {
			m.addAttribute("nullError8", error);
			 
			return "/Restaurant/RewriteRestaurant";
		}
		int id2 = Integer.parseInt(id);
		boolean checkRes = dao.checkRes(id2);
		if (checkRes == true) {
			m.addAttribute("nullError9", "編號不存在");
			 
			return "/Restaurant/RewriteRestaurant";
		}

//		int id = Integer.parseInt(req.getParameter("restaurantid"));
		int price2 = Integer.parseInt(price);
		int seat2 = Integer.parseInt(seat);

		Restaurant resBean = new Restaurant(id2, name, des, type, price2, address, phone, seat2);
		dao.RewriteRestaurant(resBean);
		m.addAttribute("success", 1);
		 

		return "/Restaurant/RewriteRestaurant";

	}
}