package cn.bdqn.biz;

import java.util.List;

import cn.bdqn.entity.Room_db;

public interface RoomBiz {

	List<Room_db> findRoom();
	
	void add(Room_db room_db);
	
}
