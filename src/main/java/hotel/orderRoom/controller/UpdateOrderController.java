package hotel.orderRoom.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.orderRoom.model.OrderBean;
import hotel.orderRoom.model.OrderDetailsBean;
import hotel.orderRoom.service.OrderService;

@Controller
public class UpdateOrderController {

	@Autowired
	private OrderService oService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(path = "/updateorder", method = RequestMethod.GET)
	public String processAction1(@RequestParam("orderid") String orderidstr, @RequestParam("username") String username,
			@RequestParam("checkindate") String checkindate, @RequestParam("checkoutdate") String checkoutdate,
			@RequestParam("roomname") String roomname, @RequestParam("roomprice") String roompriceStr,
			@RequestParam("useremail") String useremail, @RequestParam("userphone") String userphone,
			@RequestParam("adults") String adultsStr, @RequestParam("children") String childrenStr,
			@RequestParam("company") String company, @RequestParam("notes") String notes, Model m)
			throws ParseException {

		int orderid = Integer.parseInt(orderidstr.trim());
		int adults = 0;
		int children = 0;
		int roomprice = 0;
		OrderBean orderbean = null;
		OrderDetailsBean orderdetailsbean = null;

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
		Date utilcheckindate = sdf.parse(checkindate);
		Date utilcheckoutdate = sdf.parse(checkoutdate);
		java.sql.Date sqlcheckoutdate = new java.sql.Date(utilcheckoutdate.getTime());
		java.sql.Date sqlcheckindate = new java.sql.Date(utilcheckindate.getTime());

		OrderBean ob = new OrderBean();
		ob.setUsername(username);
		ob.setCheckindate(sqlcheckindate);
		ob.setCheckoutdate(sqlcheckoutdate);
		ob.setRoomname(roomname);
		ob.setRoomprice(roomprice);

		OrderDetailsBean odb = new OrderDetailsBean();
		odb.setUseremail(useremail);
		odb.setUserphone(userphone);
		odb.setAdults(adults);
		odb.setChildren(children);
		odb.setCompany(company);
		odb.setNotes(notes);

		oService.modifyOrder(orderid, ob);
		oService.modifyOrderDetails(orderid, odb);
//		orderbean = oService.findByIdforOrder(orderid);
//		orderdetailsbean = oService.findByIdforDetails(orderid);
//
//		Date checkin = orderbean.getCheckindate();
//		Date checkout = orderbean.getCheckoutdate();
//		String checkinn = sdf.format(checkin);
//		String checkoutt = sdf.format(checkout);
//
//		m.addAttribute("orderbean", orderbean);
//		m.addAttribute("orderdetailsbean", orderdetailsbean);
//		m.addAttribute("checkindate", checkinn);
//		m.addAttribute("checkoutdate", checkoutt);
		return "orderRoom/orderUpdateSuccess";
	}

	@RequestMapping(path = "/updateorder", method = RequestMethod.POST)
	public String processAction2(@RequestParam("orderid") String orderidstr, @RequestParam("username") String username,
			@RequestParam("checkindate") String checkindate, @RequestParam("checkoutdate") String checkoutdate,
			@RequestParam("roomname") String roomname, @RequestParam("roomprice") String roompriceStr,
			@RequestParam("useremail") String useremail, @RequestParam("userphone") String userphone,
			@RequestParam("adults") String adultsStr, @RequestParam("children") String childrenStr,
			@RequestParam("company") String company, @RequestParam("notes") String notes, Model m)
			throws ParseException {

		int orderid = Integer.parseInt(orderidstr.trim());
		int adults = 0;
		int children = 0;
		int roomprice = 0;
		OrderBean orderbean = null;
		OrderDetailsBean orderdetailsbean = null;

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
		Date utilcheckindate = sdf.parse(checkindate);
		Date utilcheckoutdate = sdf.parse(checkoutdate);
		java.sql.Date sqlcheckoutdate = new java.sql.Date(utilcheckoutdate.getTime());
		java.sql.Date sqlcheckindate = new java.sql.Date(utilcheckindate.getTime());

		OrderBean ob = new OrderBean();
		ob.setUsername(username);
		ob.setCheckindate(sqlcheckindate);
		ob.setCheckoutdate(sqlcheckoutdate);
		ob.setRoomname(roomname);
		ob.setRoomprice(roomprice);

		OrderDetailsBean odb = new OrderDetailsBean();
		odb.setUseremail(useremail);
		odb.setUserphone(userphone);
		odb.setAdults(adults);
		odb.setChildren(children);
		odb.setCompany(company);
		odb.setNotes(notes);

		oService.modifyOrder(orderid, ob);
		oService.modifyOrderDetails(orderid, odb);

//		orderbean = oService.findByIdforOrder(orderid);
//		orderdetailsbean = oService.findByIdforDetails(orderid);
//
//		Date checkin = orderbean.getCheckindate();
//		Date checkout = orderbean.getCheckoutdate();
//		String checkinn = sdf.format(checkin);
//		String checkoutt = sdf.format(checkout);
//
//		m.addAttribute("orderbean", orderbean);
//		m.addAttribute("orderdetailsbean", orderdetailsbean);
//		m.addAttribute("checkindate", checkinn);
//		m.addAttribute("checkoutdate", checkoutt);
		return "orderRoom/orderUpdateSuccess";
	}
}
