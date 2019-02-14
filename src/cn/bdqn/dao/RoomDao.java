package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Room_db;

public interface RoomDao {

	List<Room_db> findRoom();
	
	void add(Room_db room_db);
	
}
