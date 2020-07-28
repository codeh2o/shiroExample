package com.example.shiro.Controller;


import com.example.shiro.vo.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class OrderController {



    @RequestMapping("/video/play_record")
    public JsonData findMyPlayRecord(){
        //Subject subject = SecurityUtils.getSubject();
        Map<String ,String> recordMap = new HashMap<>();

        recordMap.put("SpringBoot入门到高级实战","第8章第1集");
        recordMap.put("Cloud微服务入门到高级实战","第4章第10集");
        recordMap.put("分布式缓存Redis","第10章第3集");

        return JsonData.buildSuccess(recordMap);

    }

}
