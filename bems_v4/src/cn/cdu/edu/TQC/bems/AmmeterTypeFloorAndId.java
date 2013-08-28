package cn.cdu.edu.TQC.bems;

import java.util.HashMap;
import java.util.List;

import cn.cdu.edu.TQC.bems.db.dao.AmmeterDao;
import cn.cdu.edu.TQC.bems.db.dao.impl.AmmeterDaoImpl;

public class AmmeterTypeFloorAndId {
	
	/**
	 * 电表
	 * 根据仪表类型和楼层号得到仪表的id
	 * @param type
	 * @param floorId 
	 * @return
	 */
	public String GetIdByTypeFloorId(String type,String floorId){
		
		return null;
	}
	
	/**
	 * 根据仪表的id
	 * 得到仪表的楼层号
	 * @param ammeterId
	 * @return
	 */
	public HashMap<String,String> GetTypeFloorIdByAmmeterID(String ammeterId ){
		return null;
	}
	
	
	
	
	

}
