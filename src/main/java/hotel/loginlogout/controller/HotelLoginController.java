package hotel.loginlogout.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.loginlogout.model.hotelBean;
import hotel.loginlogout.service.impl.LoginService1;

@Controller
public class HotelLoginController {

	@Autowired
	private LoginService1 loginService1;
	
	@GetMapping(path ="login1.controller")
	public String loginAction1()  {
		return "LoginLogout/login";
	}
	
	@GetMapping(path ="originorigin.controller")
	public String originoriginAction()  {
		return "index";
	}
	
	@GetMapping(path ="confirm.controller")
	public String confirmAction()  {
		return "LoginLogout/confirm";
	}
	

	@PostMapping(path ="insert1.controller")
	public String insertAction1()  {
		return "LoginLogout/insert";
	}
	
	@PostMapping(path ="register1.controller")
	public String registerAction1()  {
		return "LoginLogout/register";
	}
	
	@GetMapping(path ="origin.controller")
	public String originAction()  {
		return "LoginLogout/alreadyindex";
	}
	
	@RequestMapping(path ="search.controller", method = RequestMethod.GET)
	public String searchAction(@ModelAttribute("hotelBean") hotelBean hb,Model hModel)  {
		List<hotelBean> classlist = loginService1.selecthotel();
		hModel.addAttribute("classList", classlist);
		return "LoginLogout/select";
	}
	
	@RequestMapping(path ="account.controller", method = RequestMethod.POST)
	public String accountAction(HttpServletResponse response, HttpServletRequest request,@RequestParam("USER_EMAIL")String USER_EMAIL,@RequestParam("USER_PASSWORD")String USER_PASSWORD,@RequestParam("code")String code,Model hModel)  {
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		hModel.addAttribute("errorMsgMap", errorMsgMap);
		
		//防止非法登入    得到session
        HttpSession session=request.getSession(true);
        //修改session的存在時間為20s
        session.setMaxInactiveInterval(20);
        session.setAttribute("pass","ok");
		
		hotelBean temphb;
		temphb = loginService1.loginhotel(USER_EMAIL, USER_PASSWORD);
		 //得到提交的驗證碼
        System.out.println(code);
        //獲取session驗證碼
  
        String randStr =(String) session.getAttribute("randStr");
		
		if (temphb != null) {		
			 if(code.equals(randStr)) {
				 String keep = request.getParameter("keep");
                 //勾選了兩週內免登陸選項
                 if (keep != null) {

                     //建立cookie
                     Cookie cookie1 = new Cookie("USER_EMAIL", USER_EMAIL);
                     Cookie cookie2 = new Cookie("USER_PASSWORD", USER_PASSWORD);
                     //設定關聯路徑
                     cookie1.setPath(request.getContextPath());
                     cookie2.setPath(request.getContextPath());
                     //設定cookie的消亡時間  兩週
                     cookie1.setMaxAge(2 * 7 * 24 * 60 * 60);
                     cookie1.setMaxAge(2 * 7 * 24 * 60 * 60);
                     //把cookie資訊寫給瀏覽器
                     response.addCookie(cookie1);
                     response.addCookie(cookie2);
                 }
                 session.setAttribute("login", temphb);
			 }

		} else {
			errorMsgMap.put("LoginError", "帳密錯誤，請重新輸入");
		}

		if (errorMsgMap.isEmpty()) {
			return "LoginLogout/alreadyindex";
		} else {
			return "LoginLogout/login";
		}
	}
	
	@GetMapping(path ="logout.controller")
	public String searchAction(HttpServletResponse response, HttpServletRequest request)  {
		HttpSession session = request.getSession(false);// 防止建立Session
		if (session == null) {
			return "index";
		}
		int logOutStatus = 1;
		request.setAttribute("logOutStatus", logOutStatus);
		session.removeAttribute("USER_EMAIL");

		return "index";
	}
	
	@PostMapping(path ="logout.controller")
	public String searchAction2(HttpServletResponse response, HttpServletRequest request)  {
		HttpSession session = request.getSession(false);// 防止建立Session
		if (session == null) {
			return "index";
		}
		int logOutStatus = 1;
		request.setAttribute("logOutStatus", logOutStatus);
		session.removeAttribute("USER_EMAIL");

		return "index";
	}
	
	

	@PostMapping(path ="insert2.controller")
	public String insertAction2(@RequestParam("USER_NAME")String USER_NAME,@RequestParam("USER_PASSWORD")String USER_PASSWORD,@RequestParam("USER_IDENTITY")String USER_IDENTITY,
			@RequestParam("USER_EMAIL") String USER_EMAIL,@RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_BIRTHDAY") String USER_BIRTHDAY,@RequestParam("USER_REGISTRATION") String USER_REGISTRATION,Model m)  {

		hotelBean hb=new hotelBean(USER_NAME, USER_PASSWORD, USER_EMAIL, USER_PHONE, USER_IDENTITY,
				USER_BIRTHDAY, USER_REGISTRATION);
		
		loginService1.addhotel(hb);
		return "redirect:search.controller";
	}
	
	@PostMapping(path ="register2.controller")
	public String registerAction2(@RequestParam("USER_NAME")String USER_NAME,@RequestParam("USER_PASSWORD")String USER_PASSWORD,@RequestParam("USER_IDENTITY")String USER_IDENTITY,
			@RequestParam("USER_EMAIL") String USER_EMAIL,@RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_BIRTHDAY") String USER_BIRTHDAY,@RequestParam("USER_REGISTRATION") String USER_REGISTRATION,Model hModel)  {
		hotelBean hb=new hotelBean(USER_NAME, USER_PASSWORD, USER_EMAIL, USER_PHONE, USER_IDENTITY,
				USER_BIRTHDAY, USER_REGISTRATION);
		loginService1.addhotel(hb);
		String successMsg = "註冊成功!! 請登入";
		hModel.addAttribute("successMsg", successMsg);
		return "LoginLogout/login";
	}
	
	@GetMapping(path ="findById.controller")
	public String findByIdAction(@RequestParam("USER_ID") int USER_ID,Model hModel)  {
		List<hotelBean> classlist =loginService1.findById(USER_ID);
		hModel.addAttribute("classList", classlist);
		
		return "LoginLogout/update";
		
	}
	
	
	@PostMapping(path ="update.controller") 
	public String updateAction(@RequestParam("USER_ID") int USER_ID,@RequestParam("USER_NAME")String USER_NAME,@RequestParam("USER_PASSWORD")String USER_PASSWORD,@RequestParam("USER_IDENTITY")String USER_IDENTITY,
			@RequestParam("USER_EMAIL") String USER_EMAIL,@RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_BIRTHDAY") String USER_BIRTHDAY,@RequestParam("USER_REGISTRATION") String USER_REGISTRATION ,Model hModel) {
		loginService1.updatehotel(USER_ID,USER_NAME,USER_PASSWORD,USER_IDENTITY,USER_EMAIL,USER_PHONE,USER_BIRTHDAY,USER_REGISTRATION);		
		return "redirect:search.controller";
	}
	
	@PostMapping("delete.controller") 
	public String processDeleteAction(@RequestParam("USER_ID") int USER_ID) {
		loginService1.deleteById(USER_ID);
		return "redirect:search.controller";
	}
	
	
	
	
	
	
	
}
