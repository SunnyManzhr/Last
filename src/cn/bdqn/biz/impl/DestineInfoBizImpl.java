package cn.bdqn.biz.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.biz.DestineInfoBiz;
import cn.bdqn.dao.DestineInfoDao;
import cn.bdqn.entity.DestineInfo_db;

@Transactional
@Service
public class DestineInfoBizImpl implements DestineInfoBiz {

	@Autowired
	private DestineInfoDao destineInfoDao;
	
	
	public DestineInfoDao getDestineInfoDao() {
		return destineInfoDao;
	}

	public void setDestineInfoDao(DestineInfoDao destineInfoDao) {
		this.destineInfoDao = destineInfoDao;
	}

	public List<DestineInfo_db> findAll(String destine_name,Integer roomId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<DestineInfo_db> list = destineInfoDao.findAll(destine_name,roomId,pageNo,pageSize);
		for (DestineInfo_db destineInfo_db : list) {
			if(!Hibernate.isInitialized(destineInfo_db.getRoom())){
				Hibernate.initialize(destineInfo_db.getRoom());
			}
		}
		return list;
	}

	public void add(DestineInfo_db destineInfo_db) {
		// TODO Auto-generated method stub
		destineInfoDao.add(destineInfo_db);
	}

	public Integer getCount(String destine_name, Integer roomId, int pageNo,
			int pageSize) {
		return destineInfoDao.getCount(destine_name, roomId, pageNo, pageSize);
	}

}
