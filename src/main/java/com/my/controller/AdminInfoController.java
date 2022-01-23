package com.my.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.my.pojo.AdminInfo;
import com.my.pojo.Functions;
import com.my.pojo.TreeNode;
import com.my.service.AdminInfoService;
import com.my.util.JsonFactory;

@SessionAttributes(value = { "admin" })
@Controller
@RequestMapping("/admininfo")
public class AdminInfoController {
	@Autowired
	private AdminInfoService adminInfoService;

	@RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(AdminInfo ai, ModelMap model) {
		System.out.println("into login success!");
		AdminInfo admininfo = adminInfoService.login(ai);
		if (admininfo != null && admininfo.getName() != null) {
			if (adminInfoService.getAdminInfoAndFunctions(admininfo.getId()).getFs().size() > 0) {
				model.put("admin", admininfo);
				return "{\"success\":\"true\",\"message\":\"登录成功\"}";
			} else {
				return "{\"success\":\"false\",\"message\":\"您没有权限，请联系超级管理员设置权限！\"}";
			}
		} else
			return "{\"success\":\"false\",\"message\":\"登录失败\"}";
	}

	@RequestMapping("getTree")
	@ResponseBody
	public List<TreeNode> getTree(@RequestParam(value = "adminid") String adminid) {
		System.out.println("into login get tree success!");
		AdminInfo admininfo = adminInfoService.getAdminInfoAndFunctions(Integer.parseInt(adminid));
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		List<Functions> functionsList = admininfo.getFs();
		Collections.sort(functionsList);
		for (Functions functions : functionsList) {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(functions.getId());
			treeNode.setFid(functions.getParentid());
			treeNode.setText(functions.getName());
			nodes.add(treeNode);
		}
		List<TreeNode> treeNodes = JsonFactory.buildtree(nodes, 0);
		return treeNodes;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout(SessionStatus status) {
		status.setComplete();
		return "{\"success\":\"true\",\"message\":\"注销成功\"}";
	}
}
