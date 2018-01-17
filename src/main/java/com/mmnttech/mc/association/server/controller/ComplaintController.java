package com.mmnttech.mc.association.server.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmnttech.mc.association.server.common.entity.QueryEntity;
import com.mmnttech.mc.association.server.common.entity.RtnMessage;
import com.mmnttech.mc.association.server.database.entity.Complaint;
import com.mmnttech.mc.association.server.service.ComplaintService;

/**
 * @类名 ComplaintController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月15日 下午10:19:36
 * @版本 v1.0
 * 
 */
@Controller
@RequestMapping(value = "/complaint/")
public class ComplaintController {

	private Logger logger = LoggerFactory.getLogger(ComplaintController.class);
	
	@Autowired
	private ComplaintService complaintService;

	//查询投诉列表
	@ResponseBody
	@RequestMapping(value = "queryComplaintLst")
	public RtnMessage queryComplaintLst(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("queryEntity") QueryEntity queryEntity) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			List<Map<String, Object>> records = complaintService.queryComplaintLst(queryEntity);
			rtnMsg.setRtnObj(records);
		} catch (Exception e) {
			logger.error("queryComplaintLst 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_QUERY_1);
		}
		
		return rtnMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "createComplaint")
	public RtnMessage createComplaint(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("complaint") Complaint complaint) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			rtnMsg = complaintService.createComplaint(complaint);
		} catch (Exception e) {
			logger.error("queryComplaintLst 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_QUERY_1);
		}
		
		return rtnMsg;
	}
	
}
