package wn.yy.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data//注解在类上 提供类的get,set,equals,hashCode,toString等方法
@AllArgsConstructor//提供类的全参构造
@NoArgsConstructor//提供类的无参构造
@Builder//建造者模式
@Entity//
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //学号
    private String stu_id;
}
