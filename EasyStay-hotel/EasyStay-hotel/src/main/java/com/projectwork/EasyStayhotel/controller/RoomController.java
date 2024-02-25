package com.projectwork.EasyStayhotel.controller;


import java.math.BigDecimal;

import com.projectwork.EasyStayhotel.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projectwork.EasyStayhotel.response.RoomResponse;
import com.projectwork.EasyStayhotel.service.IRoomService;

import lombok.RequiredArgsConstructor;

@RestController

@RequiredArgsConstructor

@RequestMapping("/rooms")
public class RoomController {
	
	private final IRoomService roomService;
	
	
	@PostMapping("/add/new-room")
	public ResponseEntity<RoomResponse> addNewRoom(@RequestParam("photo") MultipartFile photo,@RequestParam ("roomType") String roomType,
			@RequestParam("roomPrice")BigDecimal roomPrice)
	{
		Room savedRoom = roomService.addNewRoom(photo,roomType , roomPrice);
	    RoomResponse response = new RoomResponse(savedRoom.getId(),savedRoom.getRoomType(),savedRoom.getRoomPrice()); 
	    return ResponseEntity.ok(response);
	}
}
