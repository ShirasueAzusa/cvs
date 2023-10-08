package cn.cvs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {
    private final Logger log = LogManager.getLogger(SupplierController.class);

    //查询供货商
    @RequestMapping(value = "/view")
    public String view() {
        log.info("查询供货商详情");
        return null;
    }
}
