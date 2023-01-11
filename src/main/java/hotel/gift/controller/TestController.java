package hotel.gift.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {

	@PostMapping(path="/updateGift2/{souvenir_id}")
	@ResponseBody
	public String giftUpdate(@PathVariable("souvenir_id") int id,@RequestParam("souvenir_no")String souvenir_no ) {

		System.out.println("souvenir_no:"+souvenir_no);
		return "hello";
	}
}