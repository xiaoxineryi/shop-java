package com.xiaoxin.ac.Service;

import com.xiaoxin.ac.DTO.Order;
import com.xiaoxin.ac.Entity.GoodDetail;
import com.xiaoxin.ac.Entity.Goods;
import com.xiaoxin.ac.Entity.User;
import com.xiaoxin.ac.Entity.sellShop;
import com.xiaoxin.ac.Error.CustomerError;
import com.xiaoxin.ac.Error.CustomerException;
import com.xiaoxin.ac.Mapper.GoodsMapper;
import com.xiaoxin.ac.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ShopService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Transactional
    public void buy(Order order) {
        User user = userMapper.findUserByName(order.getBuyerName());
        GoodDetail goodDetail = goodsMapper.getGoodsDetailByshopID(order.getShopID());
        if (user.getMoney() > goodDetail.getPrice() * order.getNum()){
            try {
                transfer(goodDetail.getSellerName(),user.getUserName(),goodDetail.getPrice() * order.getNum());
                goodsMapper.changeLeft(goodDetail.getShopID(),order.getNum());
                goodsMapper.addShopRecord(user.getUserName(),goodDetail.getShopID(),goodDetail.getPrice(),order.getNum());
                goodsMapper.addSellRecord(goodDetail.getSellerName(),goodDetail.getShopID(),order.getNum(),goodDetail.getPrice());
            } catch (Exception e) {
                throw new CustomerException(CustomerError.SYSTEM_ERROR);
            }
        }else{
            throw new CustomerException(CustomerError.NOT_ENOUGH_MONEY);
        }
    }

    private void transfer(String receiver,String poster,double money) throws Exception{
        userMapper.addMoney(receiver,money);
        userMapper.subMoney(poster,money);
    }

    public List<sellShop> getsellShopBySellerName(String sellerName) {
        return goodsMapper.getsellShopBySellerName(sellerName);
    }

    public sellShop getsellShopByID(int shopID) {
        return goodsMapper.getsellShopByID(shopID);
    }

    public void updateSellShop(sellShop sellShop) {
        if (goodsMapper.updateSellShop(sellShop) != 2){
            throw new CustomerException(CustomerError.DATABASE_ERROR);
        }
    }

    public sellShop addShop(String shopName, String sellerName, double price, int left, String type, List<MultipartFile> files) {
        String intype = type.split(",")[type.split(",").length-1];
        String firstLocation = intype+'/'+files.get(0).getOriginalFilename();
        System.out.println(firstLocation);
        Goods goods = new Goods(shopName,firstLocation);
        goodsMapper.addMainShop(goods);
        int shopID = goods.getShopID();
        System.out.println(shopID);
        goodsMapper.addSell(shopID,sellerName,left,price);
        for ( MultipartFile file : files){
            String location = getLocation(intype,file.getOriginalFilename());
            File f = new File(location);
            try {
                file.transferTo(f);
                goodsMapper.addDetail(shopID,intype+'/'+file.getOriginalFilename());
            } catch (IOException e) {
                throw new CustomerException(CustomerError.SAVE_ERROR);
            }
        }
        return new sellShop(shopID,shopName,firstLocation,left,price);
    }

    private String getLocation(String type,String name){
        String ImgUrl = "E:/Grade_2/WEB/ac/src/main/resources/imgs/";
        String fileDir = ImgUrl + type;

        File dir = new File(fileDir);
        if(dir.exists() == true){
            System.out.println("dirs is exists");
        }else {
            dir.mkdirs();
            System.out.println(" created dirs");
        }
            return ImgUrl+type+"/"+name;
    }
}
