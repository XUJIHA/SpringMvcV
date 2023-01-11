package hotel.orderRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.orderRoom.service.OrderService;

@Controller
public class CancelOrderController {

	@Autowired
	private OrderService oService;

	@RequestMapping(path = "/cancelorder", method = RequestMethod.GET)
	public String processAction1(@RequestParam("orderid") String orderidstr) {
		int orderid = Integer.parseInt(orderidstr);
		oService.CancelOrder(orderid);
		return "orderRoom/orderCancelSuccess";

	}

	@RequestMapping(path = "/cancelorder", method = RequestMethod.POST)
	public String processAction2(@RequestParam("orderid") String orderidstr) {
		int orderid = Integer.parseInt(orderidstr);
		oService.CancelOrder(orderid);
		return "orderRoom/orderCancelSuccess";

	}

}
