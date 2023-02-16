package com.ruoyi.project.crm.ideatest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OKController {
    @RequestMapping("/ok")
    @ResponseBody
    public String ok() {
        return "ok";
    }
}
