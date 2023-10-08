package cn.cvs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户模块
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final Logger log = LogManager.getLogger(UserController.class);

    /**
     * 查询用户详情
     */
    @GetMapping("/view")
    public String view() {
        log.info("查询用户详情");
        return null;
    }

    /**
     * 保存用户信息
     */
    @PostMapping("/save")
    public String save() {
        log.info("保存用户信息");
        return null;
    }
}
