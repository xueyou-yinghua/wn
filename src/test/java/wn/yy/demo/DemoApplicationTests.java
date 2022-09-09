package wn.yy.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wn.yy.demo.Service.*;
import wn.yy.demo.entity.*;
import wn.yy.demo.Dao.*;
import wn.yy.setup.Message;

import java.util.*;
import java.text.*;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    MajorService majorService;
    @Autowired
    InformationService informationService;

    @Test
    void contextLoads() throws ParseException {
        Message message;
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(majorService.getCode("计算机科学与技术"));
        message = informationService.addInformation(new Information("1111","张伟鹏","男","420704200012221512",dateFormat1.parse("2000-12-22"),"湖北省鄂州市高知秀园","湖北省鄂州市"));
        System.out.println(message);
        message = informationService.removeInformation("1111");
        System.out.println(message);
    }
    //模仿注册
    public void mofang(){
        //录入信息的时候需要，名字，专业，性别，生日，身份证号，家庭住址，籍贯
        String name = "张三";
        String[] str = new String[]{"计算机科学与技术","软件工程","信息安全"};
    }

    //数字变文字
    public String getCode(int code){
        String[] str = new String[]{"零","一","二","三","四","五","六","七","八","九"};
        String strC = code+"";
        if(strC.length()!=1){
            int i = code%10;
            int j = code/10;
            return str[j]+str[i];
        }
        return str[code];
    }
}
