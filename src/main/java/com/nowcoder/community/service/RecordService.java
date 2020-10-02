package com.nowcoder.community.service;

import com.nowcoder.community.dao.RecordMapper;
import com.nowcoder.community.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public int insertRecord(Record record){
        return recordMapper.insertRecord(record);
    }


}
