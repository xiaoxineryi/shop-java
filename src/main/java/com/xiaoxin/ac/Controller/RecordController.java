package com.xiaoxin.ac.Controller;

import com.xiaoxin.ac.Entity.BuyRecord;
import com.xiaoxin.ac.Resp.Resp;
import com.xiaoxin.ac.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RecordController {
    @Autowired
    RecordService recordService;

    @RequestMapping(value = "/buyRecord",method = RequestMethod.GET)
    public String getBuyRecord(@RequestParam(name = "userName") String userName){
        List<BuyRecord> buyRecordList = recordService.getBuyRecord(userName);

        return Resp.okOf(buyRecordList);
    }

    @RequestMapping(value = "/sellRecord",method = RequestMethod.GET)
    public String getSellRecord(@RequestParam(name = "sellerName") String sellerName){
        List<BuyRecord> buyRecordList = recordService.getsellRecord(sellerName);

        return Resp.okOf(buyRecordList);
    }

}
