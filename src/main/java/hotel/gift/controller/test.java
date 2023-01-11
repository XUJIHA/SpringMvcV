package hotel.gift.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {
	
	@GetMapping("/testup/{souvenir_id}")
	@ResponseBody
	public String giftUpdate(@PathVariable("souvenir_id") int id) {
		
		return id+"--------------id";
	}
	
}
