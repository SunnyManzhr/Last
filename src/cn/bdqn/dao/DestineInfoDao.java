package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.DestineInfo_db;

public interface DestineInfoDao {

	List<DestineInfo_db> findAll(String destine_name,  Integer roomId,  int pageNo,  int pageSize);
	
	void add(DestineInfo_db destineInfo_db);
	
	Integer getCount(String destine_name,  Integer roomId,  int pageNo,  int pageSize);
	
}
