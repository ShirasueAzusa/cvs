package cn.cvs.controller;

import cn.cvs.pojo.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 第一个 Spring MVC 控制器
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    Logger logger = LogManager.getLogger(HelloController.class);

    /**
     * hello Spring MVC
     */
    @RequestMapping(value = "/hello")
    public ModelAndView hello(@RequestParam String realName) {
        logger.info("你好【" + realName + "】欢迎来到 Spring MVC 课堂。");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("realName", realName);
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/hello2")
    public String hello2(Model model, @RequestParam String realName) {
        logger.info("你好【" + realName + "】欢迎来到 Spring MVC 课堂。");
        model.addAttribute("realName", realName);
        model.addAttribute(realName);
        SysUser sysUser = new SysUser();
        sysUser.setRealName(realName);
        model.addAttribute("currentUser", sysUser);
        model.addAttribute(sysUser);
        return "hello";
    }

    @RequestMapping("/hello3")
    public String hello3(Map<String, Object> map, @RequestParam String realName) {
        logger.info("你好【" + realName + "】欢迎来到 Spring MVC 课堂。");
        map.put("realName", realName);
        return "hello";
    }
}
