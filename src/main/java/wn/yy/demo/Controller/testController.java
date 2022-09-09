package wn.yy.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wn.yy.demo.entity.Information;

@RestController
@RequestMapping("/test")
public class testController {
    @RequestMapping("/one")
    public String getData(Information information){
        System.out.println(information);
        return "你好吗?";
    }
}
