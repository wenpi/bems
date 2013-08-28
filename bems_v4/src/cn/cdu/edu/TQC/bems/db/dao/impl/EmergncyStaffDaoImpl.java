/**
* @Copyright (c) 成都大学信息科学与技术学院
* 服务外包与创意大赛
*/
package cn.cdu.edu.TQC.bems.db.dao.impl;

import java.util.List;

import cn.cdu.edu.TQC.bems.db.DBManager;
import cn.cdu.edu.TQC.bems.db.bean.EmergncyStaff;
import cn.cdu.edu.TQC.bems.db.dao.EmergncyStaffDao;

/**
 * @ClassName: EmergncyStaffDaoImpl
 * 说明：
 * TODO(Tell the reader such role.)
 * @Author SUN	【email:1096490965@qq.com】
 * @Version V1.0	2012-7-17 下午1:08:56
 *
 */
public class EmergncyStaffDaoImpl implements EmergncyStaffDao{

	@Override
	public boolean addEmergncyStaff(EmergncyStaff emergncyStaff) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmergncyStaff(EmergncyStaff emergncyStaff) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmergncyStaff getEmergncyStaffById(EmergncyStaff emergncyStaff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmergncyStaff> getEmergncyStaffs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean deleteEmergncyStaff(Integer emergncyStaffId){
		String sql="delete from emergncy_staff where emergncystaffId=?";
		Object[] params=new Object[]{emergncyStaffId};
		DBManager db=new DBManager();
		if(db.ExecuteNonQuery(sql,params)==1){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public boolean deleteEmergncyStaffByStaffId(String staffId){
		String sql="delete from emergncy_staff where staffid=?";
		Object[] params=new Object[]{staffId};
		DBManager db=new DBManager();
		if(db.ExecuteNonQuery(sql,params)==1){
			return true;
		}else{
			return false;
		}
	}

}
