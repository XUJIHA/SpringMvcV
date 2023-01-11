package hotel.orderRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CancelSuccessController {

	@RequestMapping(path = "/cancelsuccess", method = RequestMethod.GET)
	public String processAction1() {
		return "orderRoom/orderCancelSuccess";

	}

	@RequestMapping(path = "/cancelsuccess", method = RequestMethod.POST)
	public String processAction2() {
		return "orderRoom/orderCancelSuccess";

	}

}
