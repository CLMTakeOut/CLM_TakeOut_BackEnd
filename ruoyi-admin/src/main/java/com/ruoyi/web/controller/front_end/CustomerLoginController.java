package com.ruoyi.web.controller.front_end;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.Customer;
import com.ruoyi.system.service.impl.CustomerServiceImpl;
import com.ruoyi.web.controller.myutils.JwtUtil;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * date: 2021/5/24 14:31
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@RequestMapping("/app")
public class CustomerLoginController {
    CustomerServiceImpl customerService;
    @Autowired
    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    // 用户登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String lgoin(@RequestBody JSONObject request){
        String tel = (String) request.get("tel");
        String pwd = (String) request.get("pwd");
        Integer id = customerService.findCustomerByTel(tel);
        JSONObject data = new JSONObject();
        Response response;
        // 用户存在判断密码正确，生成token
        if (id != null){
            Customer customer = customerService.findCustomerByTelAndPwd(tel,pwd);
            // 如果匹配到了用户的话
            if (customer != null){
                // 生成token
                String token = JwtUtil.sign(tel, id.toString());
                data.put("token",token);
                data.put("uid",id);
                data.put("tel",tel);
                response = new Response("success","200","登录成功!",data);
                return JSON.toJSONString(response);
            }else {
                response = new Response("error","666","密码错误",null);
                return JSON.toJSONString(response);
            }
        }else {
            response = new Response("warning","999","手机号不存在",null);
            return JSON.toJSONString(response);
        }
    }

    // 用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody Customer customer){
        System.out.println(customer);
        Response response;  //结果对象
        JSONObject data = new JSONObject();
        if (customer != null){
            // 判断手机号是否存在
            Integer isExist = customerService.findCustomerByTel(customer.getTelephone());

            if (isExist == null){
                int i = customerService.insertCustomer(customer);
                data.put("isExist",false);
                if (i != 0){
                    response = new Response("success","200","添加用户成功",data);
                    return JSON.toJSONString(response);
                }else {
                    response = new Response("error","666","添加失败",null);
                    return  JSON.toJSONString(response);
                }
            }else {
                data.put("isExist",true);
                return JSON.toJSONString(new Response("waring","999","该手机号已存在",data));
            }
        }else {
            response = new Response("warning","999","没有获取到数据",null);
            return  JSON.toJSONString(response);
        }
    }
}
