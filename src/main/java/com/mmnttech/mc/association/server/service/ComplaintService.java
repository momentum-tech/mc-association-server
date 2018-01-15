package com.mmnttech.mc.association.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mmnttech.mc.association.server.common.entity.QueryEntity;

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
	
	public List<Map<String, Object>> queryComplaintLst(QueryEntity queryEntity) {
		List<Object> paramLst = new ArrayList<Object>();
		
		int offset = (queryEntity.getPage() - 1) * queryEntity.getRows();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_complaint WHERE 1 = 1");
		
		sql.append(" ORDER BY create_date DESC  LIMIT ?, ?");
		paramLst.add(offset);
		paramLst.add(queryEntity.getRows());
		
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql.toString(), paramLst.toArray());
		
		return records;
	}

}
