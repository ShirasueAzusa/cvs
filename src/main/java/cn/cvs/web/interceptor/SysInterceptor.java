package cn.cvs.web.interceptor;

import cn.cvs.pojo.SysUser;
import cn.cvs.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;


public class SysInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 获取登录用户
        SysUser sysUser = (SysUser) session.getAttribute(Constants.USER_SESSION);
        // 验证登录状态
        if (null == sysUser) {
            response.sendRedirect(request.getContextPath() + "/toLogin");
            return false;
        }
        return true;
    }
}
