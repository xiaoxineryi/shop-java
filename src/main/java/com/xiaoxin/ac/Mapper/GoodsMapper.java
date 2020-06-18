package com.xiaoxin.ac.Mapper;

import com.xiaoxin.ac.Entity.GoodDescribe;
import com.xiaoxin.ac.Entity.GoodDetail;
import com.xiaoxin.ac.Entity.Goods;
import com.xiaoxin.ac.Entity.sellShop;
import org.apache.ibatis.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select * from shop limit #{st},4")
    List<Goods> getIndexGoods(int st);

    @Select("select shop.shopID,shop.shopName,shop.url from shop natural join type where type.type = #{category} limit #{st},4")
    List<Goods> getGoodsByType(String category,int st);

    @Select("select details.url from details where details.shopID = #{shopID}")
    List<GoodDescribe> getGoodDescribeByshopID(int shopID);

    @Select("SELECT shop.shopID,shop.shopName,sell.sellerName ,sell.left,sell.price FROM shop NATURAL JOIN sell WHERE shop.shopID=#{shopID}")
    GoodDetail getGoodsDetailByshopID(int shopID);

    @Update("update sell set sell.left = sell.left - #{num} where sell.shopID = #{shopID} ")
    void changeLeft(int shopID, int num);

    @Insert("insert into buy (shopID,buyerName,number,price) values (#{shopID},#{userName},#{num},#{price})")
    void addShopRecord(String userName, int shopID, double price, int num);

    @Select("select count(shopID) from shop")
    int getIndexCount();

    @Select("select count(shopID) from type where type.type = #{category}")
    int getGoodsCountByType(String category);

    @Insert("insert into sellRecord (shopID,sellerName,number,price) values (#{shopID},#{sellerName},#{num},#{price})")
    void addSellRecord(String sellerName, int shopID, int num, double price);

    @Select("select shop.shopID,shop.shopName,shop.url,sell.left,sell.price from (shop natural join sell) " +
            "where sell.sellerName = #{sellerName}")
    List<sellShop> getsellShopBySellerName(String sellerName);

    @Select("select shop.shopID,shop.shopName,shop.url,sell.left,sell.price from (shop natural join sell) " +
            "where sell.shopID = #{shopID}")
    sellShop getsellShopByID(int shopID);

    @Update("update sell natural join shop set sell.left = #{left},sell.price = #{price}," +
            "shop.shopName = #{shopName} where sell.shopID = #{shopID}")
    int updateSellShop(sellShop sellShop);

    @Insert("insert into sell (shopID,sellerName,sell.left,price) values (#{shopID},#{sellerName},#{left},#{price})")
    void addSell(int shopID, String sellerName, int left,double price);

    @Insert("insert into details (shopID,url) values (#{shopID},#{location})")
    void addDetail(int shopID, String location);

    @Insert("insert into shop (shopName,url) values (#{shopName},#{url})")
    @Options(useGeneratedKeys=true,keyProperty="shopID")
    void addMainShop(Goods goods);

    @Select("select shop.shopID,shop.shopName,shop.url,sell.left,sell.price from (shop natural join sell) ")
    List<sellShop> getAllShops();

    @Delete("DELETE sell,buy,details,shop FROM \n" +
            "(( (shop LEFT JOIN sell\n" +
            "ON shop.`shopID` = sell.`shopID` )\n" +
            "LEFT JOIN details ON shop.`shopID` = details.`shopID`)\n" +
            "LEFT JOIN buy ON shop.`shopID` = buy.`shopID`)\n" +
            "WHERE shop.`shopID` = #{shopID}")
    void deleteShop(int shopID);
}
