package cn.cvs.controller;

import cn.cvs.pojo.Supplier;
import cn.cvs.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    SupplierService supplierService;

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping("/list")
    public String list(String querySupCode, String querySupName, Model model, @RequestParam(defaultValue = "1") Integer pageIndex) {
        //每页显示的条数
        int pageSize = 5;
        //查询总记录数
        int totalSize = supplierService.selectCount(querySupCode, querySupName);
        //计算总页数
        int totalPageCount = 0;
        if (totalSize % pageSize == 0) {
            //            1.6. 编写页面
            //            1. 改造jsp/common/head.jsp中菜单里的“用户管理”链接为
            //            2. 改造jsp/sysUser/list.jsp查询表单action的提交路劲
            totalPageCount = totalSize / pageSize;
        } else {
            totalPageCount = totalSize / pageSize + 1;
        }

        //控制首页和尾页
        if (pageIndex >= totalPageCount) {
            pageIndex = totalPageCount;
        }
        if (pageIndex <= 0) {
            pageIndex = 1;
        }

        List<Supplier> list = supplierService.selectAll(pageIndex, pageSize, querySupCode, querySupName);
        model.addAttribute("totalCount", totalSize);
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("supplierList", list);
        

        //数据回显
        model.addAttribute("querySupCode", querySupCode);
        model.addAttribute("querySupName", querySupName);
        return "supplier/list";
    }
}
