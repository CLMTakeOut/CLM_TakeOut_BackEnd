package com.ruoyi.web.controller.front_end;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.Address;
import com.ruoyi.system.service.impl.AddressServiceImpl;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * date: 2021/6/3 17:09
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@RestController
@RequestMapping("/app/address")
public class FEAddressController {

    AddressServiceImpl addressService;

    @Autowired
    public void setAddressService(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    // 改变当前选择的地址
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public String updtaeAddress(@RequestBody JSONObject request){
        Integer customerId =  (Integer) request.get("customerId");
        Integer addressId = (Integer) request.get("addressId");
        System.out.println(customerId+" "+addressId);
        Response response;
        if (customerId != null && addressId != null){
            int i = addressService.updateAddressUsing(customerId, addressId);
            if (i != 0){
                response = new Response("success","200","修改成功!",null);
            }else {
                response = new Response("error","666","失败!",null);
            }
        }else {
            response = new Response("error","666","失败!",null);
        }
        return JSON.toJSONString(response);
    }

    // 加载地址列表
    @RequestMapping(value = "/getList/{uid}",method = RequestMethod.GET)
    public String getAddressList(@PathVariable("uid") Integer uid){
        // 调用addressService
        Address address = new Address();
        address.setCustomerId(uid);
        List<Address> list = addressService.selectAddressList(address);
        JSONObject data = new JSONObject();
        if (list != null){
            data.put("addressList",list);
            return JSON.toJSONString(new Response("success","200","获取列表成功!",data));
        }else {
            return JSON.toJSONString(new Response("error","666","获取列表失败!",null));
        }
    }


    // 获取当前使用的地址
    @RequestMapping(value = "/getCurrentAddress/{uid}",method = RequestMethod.GET)
    public String getCurrentAddress(@PathVariable("uid")String uid){
        Address address = new Address();
        address.setCustomerId(Integer.valueOf(uid));
        address.setUsing(1);
        List<Address> addressList = addressService.selectAddressList(address);
        JSONObject data = new JSONObject();
        if (addressList != null){
            data.put("address",addressList);
            return JSON.toJSONString(new Response("success","200","获取成功!",data));
        }else {
            return JSON.toJSONString(new Response("err","666","获取失败!",data));
        }
    }
}
