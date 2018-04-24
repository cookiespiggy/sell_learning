package com.yuantek.controller;

import com.yuantek.service.IProductInfoService;
import com.yuantek.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private IProductInfoService productInfoService;
    @GetMapping("/test")
    public ApiResponse test() {
        return productInfoService.findOne("1");
    }
    /**
     * 说明:这种才是我们想要的结果,无论传什么参数,查不到对后台也没有任何影响,我给仅仅给前端传回了
     * 一个1,让他们处理
     */
}
