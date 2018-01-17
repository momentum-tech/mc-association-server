package com.mmnttech.mc.association.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mmnttech.mc.association.server.common.entity.DictionaryConst;
import com.mmnttech.mc.association.server.common.entity.QueryEntity;
import com.mmnttech.mc.association.server.common.entity.RtnMessage;
import com.mmnttech.mc.association.server.database.entity.Complaint;
import com.mmnttech.mc.association.server.database.mappers.ComplaintMapper;
import com.mmnttech.mc.association.server.util.StringUtil;

/**
 * @类名 ComplaintService
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月15日 下午10:21:58
 * @版本 v1.0
 * 
 */

@Service("complaintService")
public class ComplaintService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ComplaintMapper complaintMapper;
	
	public List<Map<String, Object>> queryComplaintLst(QueryEntity queryEntity) {
		List<Object> paramLst = new ArrayList<Object>();
		
		int offset = (queryEntity.getPage() - 1) * queryEntity.getRows();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT cpt.*, mct.cpy_name FROM (SELECT * FROM t_complaint WHERE 1 = 1) cpt LEFT JOIN ");
		sql.append("(SELECT * FROM t_merchant) mct ON cpt.merchant_id = mct.rec_id ");
		sql.append(" ORDER BY cpt.create_date DESC  LIMIT ?, ?");
		paramLst.add(offset);
		paramLst.add(queryEntity.getRows());
		
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql.toString(), paramLst.toArray());
		
		return records;
	}
	
	
	public RtnMessage createComplaint(Complaint complaint) {
		RtnMessage rtnMsg = new RtnMessage();
		
		complaint.setRecId(StringUtil.getUUID());
		complaint.setCreateDate(new Date());
		complaint.setDate(new Date());
		complaint.setStatus(DictionaryConst.Complaint.STATUS_STANDBY);
		complaintMapper.insert(complaint);
		
		return rtnMsg;
	}
	
	
	

}
