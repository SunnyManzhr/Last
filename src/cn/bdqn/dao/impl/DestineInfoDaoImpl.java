package cn.bdqn.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.dao.DestineInfoDao;
import cn.bdqn.entity.DestineInfo_db;

public class DestineInfoDaoImpl extends HibernateDaoSupport implements DestineInfoDao {

	@SuppressWarnings({ "unchecked"})
	public List<DestineInfo_db> findAll(String destine_name, Integer roomId, int pageNo, int pageSize) {
		final StringBuffer str = new StringBuffer("select b from DestineInfo_db b where b.destine_name like '%"+destine_name+"%'");
		if(roomId != null && roomId != 0){
			str.append(" and b.room.roomId= :roomId");
		}
		return this.getHibernateTemplate().execute(
			new HibernateCallback<List<DestineInfo_db>>() {
				public List<DestineInfo_db> doInHibernate(Session session){
					Query query = session.createQuery(str.toString());
					query.setFirstResult((pageNo-1)*pageSize);
					query.setMaxResults(pageSize);
					if(roomId != null && roomId != 0){
						query.setInteger("roomId", roomId);
					}
					return query.list();
				}
			}
		);
	}

	public void add(DestineInfo_db destineInfo_db) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(destineInfo_db);
	}

	public Integer getCount(String destine_name, Integer roomId, int pageNo,
			int pageSize) {
		final StringBuffer str = new StringBuffer("select count(b) from DestineInfo_db b where b.destine_name like '%"+destine_name+"%'");
		if(roomId != null && roomId != 0){
			str.append(" and b.room.roomId= :roomId");
		}
		return this.getHibernateTemplate().execute(
			new HibernateCallback<Integer>() {
				public Integer doInHibernate(Session session){
					Query query = session.createQuery(str.toString());
					if(roomId != null && roomId != 0){
						query.setInteger("roomId", roomId);
					}
					Integer b = new Integer(query.uniqueResult().toString());
					return b ;
				}
			}
		);
	}

}
