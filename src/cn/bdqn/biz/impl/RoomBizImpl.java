package cn.bdqn.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.biz.RoomBiz;
import cn.bdqn.dao.RoomDao;
import cn.bdqn.entity.Room_db;

@Transactional
@Service
public class RoomBizImpl implements RoomBiz {

	@Autowired
	private RoomDao roomDao;
	
	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public List<Room_db> findRoom() {
		// TODO Auto-generated method stub
		return roomDao.findRoom();
	}

	public void add(Room_db room_db) {
		// TODO Auto-generated method stub
		roomDao.add(room_db);
	}

}
