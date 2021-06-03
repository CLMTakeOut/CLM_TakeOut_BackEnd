package com.ruoyi.web.controller.front_end;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.service.impl.AddressServiceImpl;
import com.ruoyi.web.controller.myutils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updtaeAddress(@RequestBody JSONObject request){
        Integer customerId = Integer.parseInt((String) request.get("customerId")) ;
        Integer addressId = Integer.parseInt((String)request.get("addressId"));
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
}
