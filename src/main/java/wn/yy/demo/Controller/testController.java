package wn.yy.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
    @RequestMapping("/one")
    public String getData(){
        return "你好吗?";
    }
}
