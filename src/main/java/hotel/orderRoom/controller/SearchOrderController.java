package hotel.orderRoom.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hotel.orderRoom.model.OrderBean;
import hotel.orderRoom.service.OrderService;

@Controller
public class SearchOrderController {

	@Autowired
	private OrderService oService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(path = "/searchorder", method = RequestMethod.GET)
	public String processAction1(Model m) {
		List<OrderBean> orderbean = oService.searchOrder();

		OrderBean ob = null;
		for (OrderBean b : orderbean) {
			ob = b;
		}
		if (ob == null) {
			return "orderRoom/orderEmpty";
		}
		Date orderd = ob.getOrderdate();
		Date checkin = ob.getCheckindate();
		Date checkout = ob.getCheckoutdate();

		String orderdd = sdf.format(orderd);
		String checkinn = sdf.format(checkin);
		String checkoutt = sdf.format(checkout);

		m.addAttribute("orderdate", orderdd);
		m.addAttribute("checkindate", checkinn);
		m.addAttribute("checkoutdate", checkoutt);
		m.addAttribute("orderbean", orderbean);
		return "orderRoom/orderSearch";
	}

	@RequestMapping(path = "/searchorder", method = RequestMethod.POST)
	public String processAction2(Model m) {

		List<OrderBean> orderbean = oService.searchOrder();

		OrderBean ob = null;
		for (OrderBean b : orderbean) {
			ob = b;
		}
		if (ob == null) {
			return "orderRoom/orderEmpty";
		} else {

			Date orderd = ob.getOrderdate();
			Date checkin = ob.getCheckindate();
			Date checkout = ob.getCheckoutdate();

			String orderdd = sdf.format(orderd);
			String checkinn = sdf.format(checkin);
			String checkoutt = sdf.format(checkout);

			m.addAttribute("orderdate", orderdd);
			m.addAttribute("checkindate", checkinn);
			m.addAttribute("checkoutdate", checkoutt);
			m.addAttribute("orderbean", orderbean);
			return "orderRoom/orderSearch";
		}
	}
}
