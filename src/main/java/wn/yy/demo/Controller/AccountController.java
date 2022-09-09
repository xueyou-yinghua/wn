package wn.yy.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wn.yy.demo.Service.UserService;
import wn.yy.demo.entity.User;
import wn.yy.setup.Message;

@RestController
@RequestMapping("/sk")
public class AccountController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Message login(@RequestBody User user) {

    }

    @RequestMapping("/register")
    public Message register(@RequestBody User user) {

    }
}
