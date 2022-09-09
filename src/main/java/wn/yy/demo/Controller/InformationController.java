package wn.yy.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wn.yy.demo.Service.InformationService;
import wn.yy.demo.entity.Information;
import wn.yy.setup.Message;

@RestController
@RequestMapping("/inform")
public class InformationController {
    @Autowired
    InformationService informationService;

    Message message;

    @RequestMapping("/add")
    public Message add(@RequestBody Information information){
        //查看这个信息的学号是否已经在了
        message = informationService.addInformation(information);
        return switch (message.getCode()) {
            case 1 -> Message.createMessage(1, "添加失败,当前数据库已有此用户信息!");
            case -10 -> Message.createMessage(-1, "添加失败,当前数据库繁忙,请稍后添加!");
            case 10 -> Message.createMessage(10, "添加成功!");
            default -> null;
        };
    }

    @RequestMapping("/delete")
    public Message delete(@RequestBody String student){
        student = student.substring(0,student.length()-1);
        System.out.println(student);
        //查看这个信息的学号是否已经在了
        message = informationService.removeInformation(student);
        return switch (message.getCode()) {
            case -1 -> Message.createMessage(1, "删除失败,当前数据库没有此用户信息!");
            case -10 -> Message.createMessage(-1, "删除失败,当前数据库繁忙,请稍后添加!");
            case 10 -> Message.createMessage(10, "删除成功!");
            default -> null;
        };
    }

    @RequestMapping("/update")
    public Message update(@RequestBody Information information){

        return null;
    }
}
