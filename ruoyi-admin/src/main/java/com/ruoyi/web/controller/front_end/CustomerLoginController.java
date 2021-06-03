package com.ruoyi.web.controller.front_end;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "HelloWorld！";
    }
}
