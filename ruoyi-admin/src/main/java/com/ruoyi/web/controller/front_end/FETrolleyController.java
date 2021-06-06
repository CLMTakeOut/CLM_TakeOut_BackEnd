package com.ruoyi.web.controller.front_end;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.Trolley;
import com.ruoyi.system.service.ITrolleyService;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2021-06-05
 */
@RestController
@RequestMapping("/app/trolley")
public class FETrolleyController{
    private ITrolleyService trolleyService;

    @Autowired
    public void setTrolleyService(ITrolleyService trolleyService) {
        this.trolleyService = trolleyService;
    }

    // 购物车列表
    @GetMapping("/list/{customerId}")
    public String list(@PathVariable("customerId")String customerId)
    {
        JSONObject data = new JSONObject();
        Trolley trolley = new Trolley();
        trolley.setCustomerId(Long.valueOf(customerId));
        List<Trolley> list = trolleyService.selectTrolleyList(trolley);
        if (list != null){
            data.put("trolleyList",list);
            return JSON.toJSONString(new Response("success","200","购物车列表获取成功",data));
        }else {
            return JSON.toJSONString(new Response("error","666","购物车列表获取失败",null));
        }
    }

    // 根据购物车Id查询
    @GetMapping(value = "/getTrolleyId/{trolleyId}")
    public String getInfo(@PathVariable("trolleyId") String trolleyId)
    {
        JSONObject data = new JSONObject();
        if (!trolleyId.equals("undefined")){
            Trolley trolley = trolleyService.selectTrolleyById(Long.valueOf(trolleyId));
            data.put("trolley",trolley);
            return JSON.toJSONString(new Response("success","200","获取信息成功",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取信息失败",null));
        }
    }

    /*添加购物车*/
    @PostMapping("/addTrolley")
    public String add(@RequestBody Trolley trolley)
    {
        if (trolley != null){
            int i = trolleyService.insertTrolley(trolley);
            return JSON.toJSONString(new Response("success","200","添加成功",null));
        }else {
            return JSON.toJSONString(new Response("error","666","添加失败",null));
        }
    }

    // 批量删除购物车商品
    @PostMapping("/deleteList")
    public String deleteList(@RequestBody JSONObject request){
        Long[] trolleyIds = JSON.toJavaObject(request.getJSONArray("trolleyIds"),Long[].class) ;
        System.out.println(JSON.toJSONString(trolleyIds));
        int i = trolleyService.deleteTrolleyByIds(trolleyIds);
        if (i != 0){
            return JSON.toJSONString(new Response("success","200","删除成功!",null));
        }else {
            return JSON.toJSONString(new Response("error","666","删除失败!",null));
        }
    }
    // 删除购物车商品
	@GetMapping("/delete/{trolleyId}")
    public String remove(@PathVariable String trolleyId)
    {
        if (!trolleyId.equals("undefined")){
            trolleyService.deleteTrolleyById(Long.valueOf(trolleyId));
            return JSON.toJSONString(new Response("success","200","删除成功!",null));
        }else {
            return JSON.toJSONString(new Response("error","666","删除失败!",null));
        }
    }

    // 清空用户的购物车
    @GetMapping("/clearAll/{customerId}")
    public String clearAll(@PathVariable String customerId){
        if (!customerId.equals("undefined")){
            trolleyService.deleteTrolleyByCustomerId(Long.valueOf(customerId));
            return JSON.toJSONString(new Response("success","200","清空成功!",null));
        }else {
            return JSON.toJSONString(new Response("error","666","清空失败!",null));
        }
    }
}
