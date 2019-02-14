package cn.bdqn.entity;

import java.util.HashSet;
import java.util.Set;

public class Room_db {
	
	private Integer roomId;
	private String room_name;
	private Set<DestineInfo_db> destineInfoSet = new HashSet<DestineInfo_db>();
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public Set<DestineInfo_db> getDestineInfoSet() {
		return destineInfoSet;
	}
	public void setDestineInfoSet(Set<DestineInfo_db> destineInfoSet) {
		this.destineInfoSet = destineInfoSet;
	}
	
}
