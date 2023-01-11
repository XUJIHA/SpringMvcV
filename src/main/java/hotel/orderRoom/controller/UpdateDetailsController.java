package hotel.orderRoom.controller;

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
public class UpdateDetailsController {

	@Autowired
	private OrderService oService;

	@RequestMapping(path = "/updatedetails", method = RequestMethod.GET)
	public String processAction1(@RequestParam("orderid") String orderidStr, Model m) {
		int orderid = Integer.parseInt(orderidStr);
		OrderBean orderbean = oService.findByIdforOrder(orderid);
		OrderDetailsBean orderdetailsbean = oService.findByIdforDetails(orderid);

		m.addAttribute("orderbean", orderbean);
		m.addAttribute("orderdetailsbean", orderdetailsbean);

		return "orderRoom/orderUpdate";
	}

	@RequestMapping(path = "/updatedetails", method = RequestMethod.POST)
	public String processAction2(@RequestParam("orderid") String orderidStr, Model m) {
		int orderid = Integer.parseInt(orderidStr);
		OrderBean orderbean = oService.findByIdforOrder(orderid);
		OrderDetailsBean orderdetailsbean = oService.findByIdforDetails(orderid);

		m.addAttribute("orderbean", orderbean);
		m.addAttribute("orderdetailsbean", orderdetailsbean);

		return "orderRoom/orderUpdate";
	}

}
