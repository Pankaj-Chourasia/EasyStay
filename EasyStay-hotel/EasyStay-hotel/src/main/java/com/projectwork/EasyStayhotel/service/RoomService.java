package com.projectwork.EasyStayhotel.service;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.projectwork.EasyStayhotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class RoomService implements IRoomService {

	
	private RoomRepository roomRepository; 
	
	@Override
	public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) {

		Room room = new Room();
		room.setRoomType(roomType);
		room.setRoomPrice(roomPrice);
		if(!file.isEmpty())
		{
			byte[] photoBytes = file.getBytes();
			Blob photoBlob = new SerialBlob(photoBytes);
			room.setPhoto(photoBlob);
		}
		return roomRepository.save(room);
		
	}
}
