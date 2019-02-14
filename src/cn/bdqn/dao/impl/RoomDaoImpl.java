package cn.bdqn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.dao.RoomDao;
import cn.bdqn.entity.Room_db;

public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao {

	@SuppressWarnings("unchecked")
	public List<Room_db> findRoom() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Room_db");
	}

	public void add(Room_db room_db) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(room_db);
	}

}
