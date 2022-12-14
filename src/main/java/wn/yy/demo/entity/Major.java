package wn.yy.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data//注解在类上 提供类的get,set,equals,hashCode,toString等方法
@AllArgsConstructor//提供类的全参构造
@NoArgsConstructor//提供类的无参构造
@Builder//建造者模式
@Entity//
@Table(name = "major")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Major {
    @Id
    @Column(name = "代码")
    private String code;

    @Column(name = "名称")
    private String name;
}
