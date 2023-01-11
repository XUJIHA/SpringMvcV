package hotel.orderRoom.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.orderRoom.model.OrderBean;
import hotel.orderRoom.model.OrderDetailsBean;

@Controller
public class CheckOrderController {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(path = "/checkorder", method = RequestMethod.GET)
	public String processAction1(@RequestParam("username") String username,
			@RequestParam("checkindate") String checkindate, @RequestParam("checkoutdate") String checkoutdate,
			@RequestParam("roomname") String roomname, @RequestParam("roomprice") String roompriceStr,
			@RequestParam("useremail") String useremail, @RequestParam("userphone") String userphone,
			@RequestParam("adults") String adultsStr, @RequestParam("children") String childrenStr,
			@RequestParam("company") String company, @RequestParam("notes") String notes, Model m)
			throws ParseException {

		int adults = 0;
		int children = 0;
		int roomprice = 0;

		if (adultsStr == null || adultsStr.trim().length() == 0) {
			adultsStr = "0";
		} else {
			adults = Integer.parseInt(adultsStr);
		}
		if (childrenStr == null || childrenStr.trim().length() == 0) {
			childrenStr = "0";
		} else {
			children = Integer.parseInt(childrenStr);
		}
		if (roompriceStr == null || roompriceStr.trim().length() == 0) {
			roompriceStr = "0";
		} else {
			roomprice = Integer.parseInt(roompriceStr);
		}

		Date orderdate = new Date();
		Date utilcheckindate = sdf.parse(checkindate);
		Date utilcheckoutdate = sdf.parse(checkoutdate);

		java.sql.Date sqlorderdate = new java.sql.Date(orderdate.getTime());
		java.sql.Date sqlcheckindate = new java.sql.Date(utilcheckindate.getTime());
		java.sql.Date sqlcheckoutdate = new java.sql.Date(utilcheckoutdate.getTime());

		OrderBean ob = new OrderBean();
		ob.setUsername(username);
		ob.setOrderdate(sqlorderdate);
		ob.setCheckindate(sqlcheckindate);
		ob.setCheckoutdate(sqlcheckoutdate);
		ob.setRoomname(roomname);
		ob.setRoomprice(roomprice);
		ob.setCanceltag(null);

		OrderDetailsBean odb = new OrderDetailsBean();
		odb.setUseremail(useremail);
		odb.setUserphone(userphone);
		odb.setAdults(adults);
		odb.setChildren(children);
		odb.setCompany(company);
		odb.setNotes(notes);

		Date checkin = ob.getCheckindate();
		Date checkout = ob.getCheckoutdate();
		String checkinn = sdf.format(checkin);
		String checkoutt = sdf.format(checkout);

		m.addAttribute("orderbean", ob);
		m.addAttribute("orderdetailsbean", odb);
		m.addAttribute("checkindate", checkinn);
		m.addAttribute("checkoutdate", checkoutt);
		return "orderRoom/orderInsert";
	}

	@RequestMapping(path = "/checkorder", method = RequestMethod.POST)
	public String processAction2(@RequestParam("username") String username,
			@RequestParam("checkindate") String checkindate, @RequestParam("checkoutdate") String checkoutdate,
			@RequestParam("roomname") String roomname, @RequestParam("roomprice") String roompriceStr,
			@RequestParam("useremail") String useremail, @RequestParam("userphone") String userphone,
			@RequestParam("adults") String adultsStr, @RequestParam("children") String childrenStr,
			@RequestParam("company") String company, @RequestParam("notes") String notes, Model m)
			throws ParseException {

		int adults = 0;
		int children = 0;
		int roomprice = 0;

		if (adultsStr == null || adultsStr.trim().length() == 0) {
			adultsStr = "0";
		} else {
			adults = Integer.parseInt(adultsStr);
		}
		if (childrenStr == null || childrenStr.trim().length() == 0) {
			childrenStr = "0";
		} else {
			children = Integer.parseInt(childrenStr);
		}
		if (roompriceStr == null || roompriceStr.trim().length() == 0) {
			roompriceStr = "0";
		} else {
			roomprice = Integer.parseInt(roompriceStr);
		}

		Date orderdate = new Date();
		Date utilcheckindate = sdf.parse(checkindate);
		Date utilcheckoutdate = sdf.parse(checkoutdate);

		java.sql.Date sqlorderdate = new java.sql.Date(orderdate.getTime());
		java.sql.Date sqlcheckindate = new java.sql.Date(utilcheckindate.getTime());
		java.sql.Date sqlcheckoutdate = new java.sql.Date(utilcheckoutdate.getTime());

		OrderBean ob = new OrderBean();
		ob.setUsername(username);
		ob.setOrderdate(sqlorderdate);
		ob.setCheckindate(sqlcheckindate);
		ob.setCheckoutdate(sqlcheckoutdate);
		ob.setRoomname(roomname);
		ob.setRoomprice(roomprice);
		ob.setCanceltag(null);

		OrderDetailsBean odb = new OrderDetailsBean();
		odb.setUseremail(useremail);
		odb.setUserphone(userphone);
		odb.setAdults(adults);
		odb.setChildren(children);
		odb.setCompany(company);
		odb.setNotes(notes);

		Date checkin = ob.getCheckindate();
		Date checkout = ob.getCheckoutdate();
		String checkinn = sdf.format(checkin);
		String checkoutt = sdf.format(checkout);

		m.addAttribute("orderbean", ob);
		m.addAttribute("orderdetailsbean", odb);
		m.addAttribute("checkindate", checkinn);
		m.addAttribute("checkoutdate", checkoutt);
		return "orderRoom/orderInsert";
	}

}
