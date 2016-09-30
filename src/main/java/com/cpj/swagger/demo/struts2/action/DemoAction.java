/*
 *
 * Copyright (c) 2011, 2016 CPJ and/or its affiliates. All rights reserved.
 * 
 */
package com.cpj.swagger.demo.struts2.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.alibaba.fastjson.JSONWriter;
import com.cpj.swagger.annotation.API;
import com.cpj.swagger.annotation.APIs;
import com.cpj.swagger.annotation.Param;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yonghuan
 */
@APIs("/demo")
@Namespace("/demo")
@Action("demoAction")
public class DemoAction extends ActionSupport {
	
	@API(value="demoAction!login", summary="示例1", parameters={
			@Param(name="username", description="用户名", type="string"),
			@Param(name="password", description="密码", type="string", format="password"),
			@Param(name="image" , description="图片", type="file", format="binary")
	})
	public void login() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());
		Map<String, String> user = new HashMap<String, String>();
		user.put("username", username);
		user.put("password", password);
		writer.writeObject(user);
		writer.flush();
		writer.close();
	}
	
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	private String password;
	public void setPassword(String password) {
		this.password = password;
	}
}
