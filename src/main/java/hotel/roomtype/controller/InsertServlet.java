package hotel.roomtype.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import hotel.roomtype.service.RoomTypeService;

@Controller
public class InsertServlet {

	@Autowired
	private RoomTypeService rService;
	
	@PostMapping("/InsertServlet")
	public String processAction(Model m, @RequestParam("roomId")@Nullable String roomId,
			@RequestParam("capacity")@Nullable String inputCapacity, @RequestParam("name")@Nullable String name,
			@RequestParam("status")@Nullable String inputStatus, @RequestParam("bed")@Nullable String inputBed,
			@RequestParam("size")@Nullable String inputSize, @RequestParam("price")@Nullable String inputPrice,
			@RequestPart("img")@Nullable MultipartFile part, @RequestParam("description")@Nullable String description,
			@RequestParam("cbEquipment1")@Nullable String equipment1, @RequestParam("cbEquipment2")@Nullable String equipment2,
			@RequestParam("cbEquipment3")@Nullable String equipment3, @RequestParam("cbEquipment4")@Nullable String equipment4,
			@RequestParam("cbEquipment5")@Nullable String equipment5, @RequestParam("cbEquipment6")@Nullable String equipment6,
			@RequestParam("cbEquipment7")@Nullable String equipment7, @RequestParam("cbEquipment8")@Nullable String equipment8
			) {
		int row = 0;
		roomId = roomId.trim();
		inputCapacity = inputCapacity.trim();
		if (roomId.equals("")) {
			m.addAttribute("idNull", "必填欄位不可空白!!");
		}
		if (inputCapacity.equals("")) {
			m.addAttribute("capacityNull", "必填欄位不可空白!!");
		}
		if (roomId.equals("") || inputCapacity.equals("")) {
			return "roomType/InsertRoom";
		}
		name = name.trim();
		if (name.equals("")) {
			name = "未命名客房";
		}
		int status = Integer.parseInt(inputStatus);
		int capacity = Integer.parseInt(inputCapacity);
		inputBed = inputBed.trim();
		if (inputBed.equals("")) {
			inputBed = "0";
		}
		int bed = Integer.parseInt(inputBed);
		inputSize = inputSize.trim();
		if (inputSize.equals("")) {
			inputSize = "0.0";
		}
		double size = Double.parseDouble(inputSize);
		inputPrice = inputPrice.trim();
		if (inputPrice.equals("")) {
			inputPrice = "0";
		}
		int price = Integer.parseInt(inputPrice);
		Blob img = null;
		try {
			InputStream is = part.getInputStream();
			byte[] b = is.readAllBytes();
			img = new SerialBlob(b);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
			if (equipment1==null) {
				equipment1 = "";
			}
			if (equipment2==null) {
				equipment2 = "";
			}
			if (equipment3==null) {
				equipment3 = "";
			}
			if (equipment4==null) {
				equipment4 = "";
			}
			if (equipment5==null) {
				equipment5 = "";
			}
			if (equipment6==null) {
				equipment6 = "";
			}
			if (equipment7==null) {
				equipment7 = "";
			}
			if (equipment8==null) {
				equipment8 = "";
			}
			String equipment = String.format("%s %s %s %s %s %s %s %s", 
								equipment1, equipment2, equipment3,equipment4,equipment5,equipment6,equipment7,equipment8);
			row = rService.insertRoomType(roomId, name, status, capacity, bed, size, price, img, description, equipment);
			System.out.println("row"+row);
			
		m.addAttribute("row", row);
		return "roomType/InsertRoom";
	}
}