package com.mmnttech.mc.association.server.database.mappers;

import com.mmnttech.mc.association.server.database.entity.Complaint;
import com.mmnttech.mc.association.server.database.entity.ComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComplaintMapper {
    int countByExample(ComplaintExample example);

    int deleteByExample(ComplaintExample example);

    int deleteByPrimaryKey(String recId);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    List<Complaint> selectByExample(ComplaintExample example);

    Complaint selectByPrimaryKey(String recId);

    int updateByExampleSelective(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByExample(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}