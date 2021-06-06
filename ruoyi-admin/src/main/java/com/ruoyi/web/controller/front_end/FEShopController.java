package com.ruoyi.web.controller.front_end;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.service.impl.ShopServiceImpl;
import com.ruoyi.web.controller.myutils.FileUtil;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * date: 2021/6/4 22:44
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@RequestMapping("/app/shop")
public class FEShopController {
    ShopServiceImpl shopService;
    @Autowired
    public void setShopService(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    // 查询店铺列表
    @RequestMapping(value = "/getShopList",method = RequestMethod.GET)
    public String getShopList(){
        JSONObject data = new JSONObject();
        List<Shop> shops = shopService.selectShopList(null);
        if (shops != null){
            data.put("shopList",shops);
            return JSON.toJSONString(new Response("success","200","获取店铺列表成功!",data));
        }else {
            return JSON.toJSONString(new Response("error","666","没有获取到数据",null));
        }
    }

    // 查询单个店铺信息
    @RequestMapping(value = "/getShopById/{shopId}",method = RequestMethod.GET)
    public String getShopById(@PathVariable("shopId")String shopId){
        JSONObject data = new JSONObject();
        Shop shop = shopService.selectShopById(Integer.valueOf(shopId));
        if (shop != null){
            data.put("shop",shop);
            return JSON.toJSONString(new Response("success","200","获取店铺信息!",data));
        }else {
            return JSON.toJSONString(new Response("error","666","没有获取到数据",null));
        }
    }

    /*获取店铺log*/
    @RequestMapping(value = "/getShopLogo/{shopId}",method = RequestMethod.GET)
    public void getGoodsPicture(@PathVariable("shopId")String shopId, HttpServletResponse response) throws IOException {
        if (!shopId.equals("undefined")){
            Shop shop = shopService.selectShopById(Integer.valueOf(shopId));
            String url = shop.getShopLogo();
            System.out.println("店铺Logo地址："+url);
            if (url != null){
                byte[] bytes = FileUtil.getFileBytes(url);
                // 设置返回类型
                response.setContentType("image/jpeg");
                response.setCharacterEncoding("UTF-8");
                ServletOutputStream stream = response.getOutputStream();
                stream.write(bytes);
            }
        }
    }
}
