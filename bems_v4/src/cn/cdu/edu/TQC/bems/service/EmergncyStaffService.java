/**
* @Copyright (c) 成都大学信息科学与技术学院
* 服务外包与创意大赛
*/
package cn.cdu.edu.TQC.bems.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import cn.cdu.edu.TQC.bems.db.bean.EmergncyStaff;
import cn.cdu.edu.TQC.bems.db.dao.EmergncyStaffDao;
import cn.cdu.edu.TQC.bems.db.dao.impl.EmergncyGroupDaoImpl;
import cn.cdu.edu.TQC.bems.db.dao.impl.EmergncyStaffDaoImpl;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.spi.resource.Singleton;

/**
 * @ClassName: EmergncyStaffService
 * 说明：
 * TODO(Tell the reader such role.)
 * @Author SUN	【email:1096490965@qq.com】
 * @Version V1.0	2012-7-17 下午1:03:58
 *
 */

@Path("/emergncyStaffService")
@Singleton
public class EmergncyStaffService {
	
	private EmergncyStaffDao dao=null;
	public EmergncyStaffService(){
		dao=new EmergncyStaffDaoImpl();
	}
	
	@POST
	@Path("createemergncystaff")
	@Produces("application/xml")
	public Response createEmergncyStaff(
			@FormParam("staffId") String staffId,
			@FormParam("position") String poistion,
			@FormParam("emergncyGroupId") Integer emergncyGroupId
			){
		EmergncyStaff emergncyStaff=new EmergncyStaff();
		try{
			dao.addEmergncyStaff(emergncyStaff);
		}catch(Exception e){
			e.printStackTrace();
		}
		Response res = null;
		res = Response.ok(emergncyStaff).type("application/xml").build();
		return res;
	}
	
	
	@GET
	@Path("del/{id}")
	@Produces("application/xml")
	public Response delEmergncyStaffById(
			@PathParam("id") Integer id){
		String xmlString="";
		try{
			if(dao.deleteEmergncyStaff(id)){
				xmlString="删除成功";
			}else{
				xmlString="删除失败";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Response res; 
        ResponseBuilder builder = Response.status(Status.CREATED);
        builder.type("application/xml");
        builder.entity("<message>"+xmlString+"</message>");
        res = builder.build();
        return res;
		
	}
	
	@GET
	@Path("delbystaffid/{id}")
	@Produces("application/xml")
	public Response delEmergncyStaffByStaffId(
			@PathParam("id") String id){
		String xmlString="";
		try{
			if(dao.deleteEmergncyStaffByStaffId(id)){
				xmlString="删除成功";
			}else{
				xmlString="删除失败";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Response res; 
        ResponseBuilder builder = Response.status(Status.CREATED);
        builder.type("application/xml");
        builder.entity("<message>"+xmlString+"</message>");
        res = builder.build();
        return res;
	}
	
	
	
	

}
