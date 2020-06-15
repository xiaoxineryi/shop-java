package com.xiaoxin.ac.Service;

import com.xiaoxin.ac.Entity.BuyRecord;
import com.xiaoxin.ac.Mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    RecordMapper recordMapper;

    public List<BuyRecord> getBuyRecord(String userName) {
        return recordMapper.getBuyRecord(userName);
    }

    public List<BuyRecord> getsellRecord(String sellerName) {return recordMapper.getSellRecord(sellerName);
    }
}
