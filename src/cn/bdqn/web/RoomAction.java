package cn.bdqn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bdqn.biz.RoomBiz;
import cn.bdqn.entity.Room_db;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RoomAction extends ActionSupport {

	@Autowired
	private RoomBiz roomBiz;

	public RoomBiz getRoomBiz() {
		return roomBiz;
	}

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}
	
	private Map<Integer, String> roomMap = new HashMap<Integer, String>();

	public Map<Integer, String> getRoomMap() {
		return roomMap;
	}

	public void setRoomMap(Map<Integer, String> roomMap) {
		this.roomMap = roomMap;
	}

	public String toAdd(){
		roomList = roomBiz.findRoom();
		for (Room_db room : roomList) {
			roomMap.put(room.getRoomId(), room.getRoom_name());
			System.out.println(room.getRoom_name());
		}
		return SUCCESS;
	}
	
	private List<Room_db> roomList;

	public List<Room_db> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room_db> roomList) {
		this.roomList = roomList;
	}
	
}
