/**
* @Copyright (c) 成都大学信息科学与技术学院
* 服务外包与创意大赛
*/
package cn.cdu.edu.TQC.bems.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.cdu.edu.TQC.bems.Analasis;
import cn.cdu.edu.TQC.bems.Utils;
import cn.cdu.edu.TQC.bems.db.bean.MeterData;
import cn.cdu.edu.TQC.bems.db.bean.Template;
import cn.cdu.edu.TQC.bems.db.dao.TemplateDao;
import cn.cdu.edu.TQC.bems.db.dao.impl.MeterDataDaoImpl;
import cn.cdu.edu.TQC.bems.db.dao.impl.TemplateDaoImpl;

/**
 * @ClassName: Test
 * 说明：
 * TODO(Tell the reader such role.)
 * @Author LPM	【email:shouli1990@gmail.com 】
 * @Version V1.0	2012-7-5 下午8:42:17
 *
 */
public class Test {

    public static void main(String[] args) {
//	List<HashMap<String, Object>> all = new Analasis().getComsumData("meter", "20000001", new Date("2012/1/10"),new Date("2012/2/27"));
	Date begin = new Utils().stringToDate(2012+"0101000000");
	Date end = new Utils().stringToDate(2012+"1230000000");
	double da = new Analasis().getAmongData("ammeter", "20120005", begin,end);
	System.out.println("******"+da);	
	
	System.out.println(new Utils().getStringDate(new Date()).get("year"));
    }
    
   

}
