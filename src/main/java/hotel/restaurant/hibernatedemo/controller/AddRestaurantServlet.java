package hotel.restaurant.hibernatedemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
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
public class AddRestaurantServlet {
	
	@Autowired
	private RestaurantDao dao ;

	@PostMapping("/AddRestaurantServlet")
	protected String addRestaurant(@RequestParam("restaurantname")@Nullable String name, @RequestParam("restaurantdes")@Nullable String des,
			@RequestParam("restauranttype")@Nullable String type, @RequestParam("restaurantaddress")@Nullable String address,
			@RequestParam("restaurantphone")@Nullable String phone, @RequestParam("restaurantseat")@Nullable String seat,
			@RequestParam("restaurantprice")@Nullable String price, Model m) {

		String error = "不能輸入空白";

		if (name == "") {
			m.addAttribute("nullError2", error);
			
			return "/Restaurant/AddRestaurant";
		}
		if (des == "") {
			m.addAttribute("nullError3", error);
			
			return "/Restaurant/AddRestaurant";
		}
		if (type == "") {
			m.addAttribute("nullError4", error);
			
			return "/Restaurant/AddRestaurant";
		}
		if (price == "") {
			m.addAttribute("nullError5", error);
			
			return "/Restaurant/AddRestaurant";
		}
		int price2 = Integer.parseInt(price);
		if (price == "") {
			m.addAttribute("nullError6", error);
			
			return "/Restaurant/AddRestaurant";
		}
		if (phone == "") {
			m.addAttribute("nullError7", error);
			
			return "/Restaurant/AddRestaurant";
		}
		if (seat == "") {
			m.addAttribute("nullError8", error);
			
			return "/Restaurant/AddRestaurant";
		}
		int seat2 = Integer.parseInt(seat);


		Restaurant resBean = new Restaurant(name, des, type, price2, address, phone, seat2);
		dao.AddRestautant(resBean);
		m.addAttribute("success", 1);
		
		return "/Restaurant/AddRestaurant";

	}
}
