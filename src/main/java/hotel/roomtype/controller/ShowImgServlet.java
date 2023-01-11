package hotel.roomtype.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.roomtype.model.RoomsBean;
import hotel.roomtype.service.RoomTypeService;

@Controller
public class ShowImgServlet {

	@Autowired
	private RoomTypeService rService;

	@RequestMapping(path = "/ShowImgServlet", method = RequestMethod.GET)
	public void processAction(@RequestParam("roomId") String roomId, HttpServletResponse response) {
		List<RoomsBean> beans = rService.findById(roomId);
		RoomsBean bean = null;
		for (RoomsBean b : beans) {
			bean = b;
		}
		try {
			Blob blob = bean.getImg();
			InputStream is = blob.getBinaryStream();
			OutputStream os = response.getOutputStream();
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				os.flush();
			}
			os.close();
			is.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
