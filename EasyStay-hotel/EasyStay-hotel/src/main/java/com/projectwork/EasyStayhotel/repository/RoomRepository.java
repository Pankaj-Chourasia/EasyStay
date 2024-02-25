package com.projectwork.EasyStayhotel.repository;

import com.projectwork.EasyStayhotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query("SELECT DISTINCT r.RoomType FROM Room r")
    List<String> findDistinctRoomTypes();
}
