package wn.yy.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data//注解在类上 提供类的get,set,equals,hashCode,toString等方法
@AllArgsConstructor//提供类的全参构造
@NoArgsConstructor//提供类的无参构造
@Builder//建造者模式
@Entity//
@Table(name = "information")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Information {

    //学号
    @Id
    private String stu_id;

    //名字
    private String name;

    //性别
    private String sex;

    //身份证号
    private String identity;

    //生日
    private Date birthday;

    //地址
    private String place;

    //籍贯
    private String n_place;
}
