package cn.bdqn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bdqn.biz.DestineInfoBiz;
import cn.bdqn.biz.RoomBiz;
import cn.bdqn.entity.DestineInfo_db;
import cn.bdqn.entity.Room_db;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DestineInfoAction extends ActionSupport {

	@Autowired
	private DestineInfoBiz destineInfoBiz;

	public DestineInfoBiz getDestineInfoBiz() {
		return destineInfoBiz;
	}

	public void setDestineInfoBiz(DestineInfoBiz destineInfoBiz) {
		this.destineInfoBiz = destineInfoBiz;
	}
	
	private List<DestineInfo_db> destineInfoList;
	
	public List<DestineInfo_db> getDestineInfoList() {
		return destineInfoList;
	}

	public void setDestineInfoList(List<DestineInfo_db> destineInfoList) {
		this.destineInfoList = destineInfoList;
	}

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

	private List<Room_db> roomList;

	public List<Room_db> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room_db> roomList) {
		this.roomList = roomList;
	}
	
	public void setRoomMap(Map<Integer, String> roomMap) {
		this.roomMap = roomMap;
	}
	
	private Integer roomId;
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getDestine_name() {
		return destine_name;
	}

	public void setDestine_name(String destine_name) {
		this.destine_name = destine_name;
	}

	private String destine_name = "";
	
	private Integer pageNo=1;
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	private Integer pageSize=3;
	
	private Integer pageCount;
	
	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	private Integer pageNoCount;
	
	

	public Integer getPageNoCount() {
		return pageNoCount;
	}

	public void setPageNoCount(Integer pageNoCount) {
		this.pageNoCount = pageNoCount;
	}

	public String findAll(){
		System.out.println("");
		roomList = roomBiz.findRoom();
		for (Room_db room : roomList) {
			roomMap.put(room.getRoomId(), room.getRoom_name());
			System.out.println(room.getRoom_name());
		}
		pageCount = destineInfoBiz.getCount(destine_name, roomId, pageNo, pageSize);
		pageNoCount = pageCount%pageSize==0?pageCount/pageSize:(pageCount/pageSize)+1;
		destineInfoList = destineInfoBiz.findAll(destine_name,roomId,pageNo,pageSize);
		return SUCCESS;
	}
	
	private DestineInfo_db destineInfo_db;
	
	public DestineInfo_db getDestineInfo_db() {
		return destineInfo_db;
	}

	public void setDestineInfo_db(DestineInfo_db destineInfo_db) {
		this.destineInfo_db = destineInfo_db;
	}

	public String add(){
		destineInfoBiz.add(destineInfo_db);
		return "redirectAction";
	}
	
	
}
