package com.ruoyi.web.controller.front_end;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.Order;
import com.ruoyi.system.domain.OrderGoods;
import com.ruoyi.system.service.impl.OrderGoodsServiceImpl;
import com.ruoyi.system.service.impl.OrderServiceImpl;
import com.ruoyi.system.service.impl.TrolleyServiceImpl;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * date: 2021/6/6 10:53
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@RequestMapping("/app/order")
public class FEOrderController {
    OrderServiceImpl orderService;
    OrderGoodsServiceImpl orderGoodsService;
    TrolleyServiceImpl trolleyService;
    @Autowired
    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
    @Autowired
    public void setOrderGoodsService(OrderGoodsServiceImpl orderGoodsService) {
        this.orderGoodsService = orderGoodsService;
    }
    @Autowired
    public void setTrolleyService(TrolleyServiceImpl trolleyService) {
        this.trolleyService = trolleyService;
    }

    /*根据订单id获取对应订单信息*/
    @RequestMapping(value = "/getOrderInfo/{orderId}",method = RequestMethod.GET)
    public String getOrderInfo(@PathVariable("orderId")String orderId){
        Order order = orderService.selectOrderById(Long.valueOf(orderId));
        JSONObject data = new JSONObject();
        if (order != null){
            data.put("orderInfo",order);
            return JSON.toJSONString(new Response("success","200","获取订单数据成功",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取数据失败!",null));
        }
    }
    // 查询订单列表
    @RequestMapping(value = "/getOrderList/{customerId}",method = RequestMethod.GET)
    public String getOrderList(@PathVariable("customerId")String customerId){
        Order order = new Order();
        order.setCustomerId(Integer.valueOf(customerId));
        JSONObject data = new JSONObject();
        List<Order> orders = orderService.selectOrderList(order);
        if (orders != null){
            data.put("orderList",orders);
            return JSON.toJSONString(new Response("success","200","获取订单列表成功!",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取数据失败!",null));
        }
    }

    /*根据订单id查询对应的商品信息*/
    @RequestMapping(value = "/getOrderGoodsList/{orderId}",method = RequestMethod.GET)
    public String getOrderGoodsInfo(@PathVariable("orderId") String orderId){
        ArrayList<OrderGoods> orderGoods = orderGoodsService.selectOrderGoodsById(Integer.valueOf(orderId));
        JSONObject data = new JSONObject();
        if (orderGoods != null){
            data.put("orderGoodsList",orderGoods);
            return JSON.toJSONString(new Response("success","200","获取订单商品数据成功!",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取订单商品数据失败!",null));
        }
    }


    /*添加订单商品*/
    @RequestMapping(value = "/addOrderGoods",method = RequestMethod.POST)
    public String addOrderGoods(@RequestBody JSONObject request){
        ArrayList<OrderGoods> orderGoodsList =  JSON.toJavaObject(request.getJSONArray("orderGoodsList"),ArrayList.class);
        System.out.println(JSON.toJSONString(orderGoodsList));
        int i = orderGoodsService.insertGoodsList(orderGoodsList);
        if (i != 0){
            return JSON.toJSONString(new Response("success","200","插入成功!",null));
        }else {
            return JSON.toJSONString(new Response("error","666","插入失败!",null));
        }
    }

    /*创建订单*/
    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public String createOrder(@RequestBody Order order){
        System.out.println(order);
        int i = orderService.insertOrder(order);
        Long orderId = order.getOrderId();
        JSONObject data = new JSONObject();
        if (i != 0){
            data.put("orderId",orderId);
            return JSON.toJSONString(new Response("success","200","插入成功!",data));
        }else {
            return JSON.toJSONString(new Response("error","666","插入失败!",null));
        }
    }

    // 根据id删除订单
    @RequestMapping(value = "/deleteOrder/{orderId}",method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("orderId") String orderId){
        int i = orderService.deleteOrderById(Long.valueOf(orderId));
        if (i != 0){
            return JSON.toJSONString(new Response("success","200","删除订单成功!",null));
        }else {
            return JSON.toJSONString(new Response("error","666","删除失败!",null));
        }
    }
}
