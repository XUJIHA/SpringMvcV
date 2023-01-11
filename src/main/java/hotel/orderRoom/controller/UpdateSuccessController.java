package hotel.orderRoom.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdateSuccessController {
	@RequestMapping(path = "/updatesuccess",method=RequestMethod.GET)
	public String processAction1(){
		return "orderRoom/orderUpdateSuccess";
	}
	
	@RequestMapping(path = "/updatesuccess",method=RequestMethod.POST)
	public String processAction2() {
		return "orderRoom/orderUpdateSuccess";
	}
}
