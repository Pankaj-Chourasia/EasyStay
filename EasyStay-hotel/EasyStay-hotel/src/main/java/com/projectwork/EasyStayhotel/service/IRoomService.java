package com.projectwork.EasyStayhotel.service;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.projectwork.EasyStayhotel.controller.Room;

public interface IRoomService {

	Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice);
	
}
