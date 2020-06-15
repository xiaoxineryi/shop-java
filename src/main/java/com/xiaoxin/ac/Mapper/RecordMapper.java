package com.xiaoxin.ac.Mapper;

import com.xiaoxin.ac.Entity.BuyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {

    @Select("select shop.url,shop.shopName,buy.number,buy.price from shop natural join buy where buy.buyerName = #{userName}")
    List<BuyRecord> getBuyRecord(String userName);

    @Select("select shop.url,shop.shopName,sellRecord.number,sellRecord.price from shop natural join sellRecord" +
            " where sellRecord.sellerName = #{userName}")
    List<BuyRecord> getSellRecord(String sellerName);
}
