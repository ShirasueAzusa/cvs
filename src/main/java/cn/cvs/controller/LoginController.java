package cn.cvs.controller;

import cn.cvs.pojo.SysUser;
import cn.cvs.service.SysUserService;
import cn.cvs.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController extends BaseController {
    private SysUserService sysUserService;

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/toLogin")
    public String login() {
        return "login";
    }

    /**
     * 登录接口
     *
     * @param account
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/login")
    public String doLogin(String account, String password, HttpServletRequest request) {
//调用service方法，进行用户匹配
        SysUser sysUser = sysUserService.login(account, password);
        if (null != sysUser) {//登录成功
            request.getSession().setAttribute(Constants.USER_SESSION, sysUser);
            return "redirect:/toMain";
        } else {
            request.setAttribute("error", "用户名或密码不正确");
            return "login";
        }
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constants.USER_SESSION);
        return "login";
    }

    /**
     * 跳转到首页
     */
    @RequestMapping("/toMain")
    public String toMain(HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.USER_SESSION) == null) {
            return "redirect:/toLogin";
        }
        return "frame";
    }
}
