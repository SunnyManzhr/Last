package cn.bdqn.entity;

import java.util.Date;

public class DestineInfo_db {

	private Integer id;
	private Room_db room;
	private Date destine_time;
	private String destine_name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Room_db getRoom() {
		return room;
	}
	public void setRoom(Room_db room) {
		this.room = room;
	}
	public Date getDestine_time() {
		return destine_time;
	}
	public void setDestine_time(Date destine_time) {
		this.destine_time = destine_time;
	}
	public String getDestine_name() {
		return destine_name;
	}
	public void setDestine_name(String destine_name) {
		this.destine_name = destine_name;
	}
	
	
	
}
