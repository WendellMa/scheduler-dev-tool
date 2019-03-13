package com.abigail.core.swagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 * @since 1.0.0
 * @author myq
 */
@Controller
@Slf4j
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        log.info("访问 swagger ui");
        return "redirect:swagger-ui.html";
    }
}
