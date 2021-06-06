package com.ruoyi.web.controller.front_end;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.service.impl.GoodsServiceImpl;
import com.ruoyi.web.controller.myutils.FileUtil;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * date: 2021/6/5 9:04
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@RequestMapping("/app/goods")
public class FEGoodsController {
    GoodsServiceImpl goodsService;
    @Autowired
    public void setGoodsService(GoodsServiceImpl goodsService) {
        this.goodsService = goodsService;
    }
    //按照店铺id和商品类型进行查询
    @RequestMapping(value = "/getListByType/{shopId}/{type}",method = RequestMethod.GET)
    public String getGoodsListByType(@PathVariable("shopId")Integer shopId,@PathVariable("type")String type){
        System.out.println(shopId+""+type);
        JSONObject data = new JSONObject();
        Goods goods = new Goods();
        goods.setShopId(shopId);
        goods.setGoodsType(type);
        List<Goods> goodsList = goodsService.selectGoodsList(goods);
        if (goodsList != null){
            data.put("goodsList",goodsList);
            return JSON.toJSONString(new Response("success","200","获取商品列表成功",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取商品列表失败",null));
        }
    }

    //按照店铺id和推荐进行查询
    @RequestMapping(value = "/getListByRecommend/{shopId}/{recommend}",method = RequestMethod.GET)
    public String getGoodsListByRecommend(@PathVariable("shopId")Integer shopId,@PathVariable("recommend")Integer recommend){
        System.out.println(shopId+""+recommend);
        JSONObject data = new JSONObject();
        Goods goods = new Goods();
        goods.setShopId(shopId);
        goods.setGoodsRecommend(recommend);
        List<Goods> goodsList = goodsService.selectGoodsList(goods);
        if (goodsList != null){
            data.put("goodsList",goodsList);
            return JSON.toJSONString(new Response("success","200","获取商品列表成功",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取商品列表失败",null));
        }
    }

    // 获取全部的美食推荐
    @RequestMapping(value = "/getListAllRecommend",method = RequestMethod.GET)
    public String getGoodsListAllRecommend(){
        JSONObject data = new JSONObject();
        Goods goods = new Goods();
        goods.setGoodsRecommend(1);
        List<Goods> goodsList = goodsService.selectGoodsList(goods);
        if (goodsList != null){
            data.put("goodsList",goodsList);
            return JSON.toJSONString(new Response("success","200","获取商品列表成功",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取商品列表失败",null));
        }
    }

    // 获取销量排行前十
    @RequestMapping(value = "/getConsider",method = RequestMethod.GET)
    public String getConsider(){
        List<Goods> goodsList = goodsService.getConsider();
        JSONObject data = new JSONObject();
        data.put("goodsList",goodsList);
        if (goodsList != null){
            return JSON.toJSONString(new Response("success","200","获取商品列表成功",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取商品列表成功",null));
        }
    }
    @RequestMapping(value = "/getGoodsPicture/{goodsId}",method = RequestMethod.GET)
    public void getGoodsPicture(@PathVariable("goodsId")String goodsId, HttpServletResponse response) throws IOException {
        if ( !goodsId.equals("undefined")){
            Goods goods = goodsService.selectGoodsById(Integer.valueOf(goodsId));
            String url = goods.getGoodsLogo();
            System.out.println("头像地址："+url);
            if (url != null){
                byte[] bytes = FileUtil.getFileBytes(url);
                // 设置返回类型
                response.setContentType("image/jpeg");
                response.setCharacterEncoding("UTF-8");
                ServletOutputStream stream = response.getOutputStream();
//            System.out.println("长度:"+bytes.length);
                stream.write(bytes);
            }
        }
    }
}
