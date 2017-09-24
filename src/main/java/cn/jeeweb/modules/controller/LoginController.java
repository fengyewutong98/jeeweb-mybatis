package cn.jeeweb.modules.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jeeweb.modules.entity.User;
import cn.jeeweb.modules.service.IUser;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IUser iUser;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response,String userName) {
		HttpSession session = request.getSession();
		
		
		User user = iUser.getUser(userName);
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
		try {
			if(user==null) {
				User user1 = new User();
				user1.setUserName(userName);
				user1.setMobile(userName);
				int i = iUser.addUser(null, user1);
				session.setAttribute("userId", i);
			}
			json.put("returnCode", "000000");
	        json.put("returnMsg", "成功");
		}catch(Exception e){
			json.put("returnCode", "111111");
	        json.put("returnMsg", "服务器异常");
			log.info("错误异常"+e);
		}
		session.setAttribute("phone",user.getMobile());
		session.setAttribute("userId",user.getUserId());
		
		log.info("--查询成功--");
		
		try {
		    PrintWriter out = response.getWriter();
			out.write(callback+'('+json+')'); 
	        out.flush(); 
	        log.info("--回调数据成功成功--");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
