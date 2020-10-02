package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Record;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordMapper {

    int insertRecord(Record record);

    Record selectRecord(int userId,int entityType,int entityId,int operaType);

}
