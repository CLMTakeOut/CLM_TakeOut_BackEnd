package com.ruoyi.web.controller.front_end;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.Customer;
import com.ruoyi.system.service.impl.CustomerServiceImpl;
import com.ruoyi.web.controller.myutils.JwtUtil;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * date: 2021/6/3 11:43
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@RequestMapping("/app/customer")
public class FECustomerController {
    CustomerServiceImpl customerService;
    @Autowired
    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }


    // 获取用户信息
    @RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    public String getCustomer(@PathVariable("uid") Integer id, HttpServletRequest request){
        String token = request.getHeader("token");
        Response response;
        JSONObject jsonObject = new JSONObject();
        if (id != null && JwtUtil.verity(token)){
            Customer customer = customerService.selectCustomerById(id);
            jsonObject.put("customer",customer);
            response = new Response("success","200","获取用户信息成功",jsonObject);
            return  JSON.toJSONString(response);
        }else {
            response = new Response("warning","999","没有获取到,没有权限",null);
            return  JSON.toJSONString(response);
        }
    }

}
