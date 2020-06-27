package com.shuimutong.learn.basestart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/normal")
public class NormalController {
    @RequestMapping(path = "/getNum")
    public @ResponseBody String getNum() {
        System.out.println("Hello, this is getNum");
        return "666";
    }
}
