package cn.cvs.controller;

import cn.cvs.pojo.SysRole;
import cn.cvs.pojo.SysUser;
import cn.cvs.service.SysRoleService;
import cn.cvs.service.SysUserService;
import cn.cvs.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    private SysUserService sysUserService;

    private SysRoleService sysRoleService;

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Autowired
    public void setSysRoleService(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping("/toLogin")
    public String login() {
        System.out.println("shaoshao");
        return "login";
    }

    /**
     * 登录接口
     */
    @RequestMapping("/login")
    public String doLogin(String account, String password, HttpServletRequest request) {

        SysUser sysUser = sysUserService.login(account, password);
        if (null != sysUser) {
            request.getSession().setAttribute(Constants.USER_SESSION, sysUser);
            return "redirect:/sysUser/toMain";
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


    @ExceptionHandler(value = {RuntimeException.class})
    public String handlerException(Exception e, HttpServletRequest request) {
        request.setAttribute("e", e);
        return "sysError";
    }

    @RequestMapping("/exLogin")
    public String exLogin(String account, String password) {
        SysUser user = sysUserService.login(account, password);
        if (null == user) {//登录失败
            throw new RuntimeException("用户名或者密码不正确，跳转到错误页面！");
        }
        return "redirect:/sysUser/toMain";
    }

    /**
     * 跳转到首页
     */
    @RequestMapping("/toMain")
    public String toMain(HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.USER_SESSION) == null) {
            return "redirect:/sysUser/toLogin";
        }
        return "frame";
    }

    /**
     * 查询用户列表
     */
    @RequestMapping(value = "/list")
    public String list(Model model, String queryRealName, Integer queryRoleId,
                       @RequestParam(defaultValue = "1") Integer pageIndex) {
        //设置每页显示的条数
        int pageSize = 5;
        //查询总记录数
        int totalCount = sysUserService.selectCount(queryRealName, queryRoleId);
        //计算总页数
        int totalPageCount = 0;
        if (totalCount % pageSize == 0) {
            totalPageCount = totalCount / pageSize;
        } else {
            totalPageCount = totalCount / pageSize + 1;
        }
        //控制首页和尾页
        if (pageIndex >= totalPageCount) {
            pageIndex = totalPageCount;
        }
        if (pageIndex <= 0) {
            pageIndex = 1;
        }

        //分页查询用户记录
        List<SysUser> userList = sysUserService.selectList(queryRealName,
                queryRoleId, pageIndex, pageSize);
        //将分页信息保存到model
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("userList", userList);
        //查询信息回显
        model.addAttribute("queryRealName", queryRealName);
        model.addAttribute("queryRoleId", queryRoleId);
        //查询角色列表 给列表角色下拉框展示
        List<SysRole> roleList = sysRoleService.selectList();
        model.addAttribute("roleList", roleList);
        return "sysUser/list";
    }

    /**
     * 跳转到添加用户页面
     */
    @GetMapping("/toAdd")
    public String toAdd() {
        return "sysUser/add";
    }

    /**
     * 添加用户
     */
    @PostMapping("/add")
    public String add(SysUser sysUser, HttpSession session) {
        //设置创建人id
        sysUser.setCreatedUserId(((SysUser) session.getAttribute(Constants.USER_SESSION))
                .
                getId());
        if (sysUserService.insert(sysUser) > 0) {
            return "redirect:/sysUser/list";
        }
        return "sysUser/add";
    }


    /**
     * 跳转到修改用户页面
     */
    @GetMapping("/toUpdate")
    public String toUpdate(Integer uid, Model model) {
        SysUser sysUser = sysUserService.selectById(uid);
        model.addAttribute(sysUser);
        return "sysUser/update";
    }


    /**
     * 修改用户信息
     */
    @PostMapping("/update")
    public String update(SysUser sysUser, HttpSession session) {
        sysUser.setUpdatedUserId(((SysUser) session.getAttribute(Constants.USER_SESSION))
                .
                getId());
        if (sysUserService.update(sysUser) > 0) {
            return "redirect:/sysUser/list";
        }
        return "sysUser/update";
    }


    /**
     * 查询用户详情
     */
    @GetMapping("/view")
    public String view(Integer id, Model model) {
        SysUser sysUser = sysUserService.selectById(id);
        model.addAttribute(sysUser);
        return "sysUser/view";
    }
}
