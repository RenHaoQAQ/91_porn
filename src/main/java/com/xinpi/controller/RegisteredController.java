package com.xinpi.controller;

import com.xinpi.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类 名 称：RegisteredController
 * 类 描 述：用户注册
 * 创建时间：2019-08-07 16:09
 * 创 建 人：renhao
 */
@Controller
@RequestMapping("registered")
public class RegisteredController {

    @GetMapping("show")
    public String showRegistered (){
        return "registered";
    }

    /*
    * 执行注册*/
    @PostMapping("doRegistered")
    public void doRegistered (@RequestBody UserEntity userEntity){
        System.out.println("userEntity = " + userEntity);
    }
}
