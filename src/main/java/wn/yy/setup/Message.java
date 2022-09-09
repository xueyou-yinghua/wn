package wn.yy.setup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//注解在类上 提供类的get,set,equals,hashCode,toString等方法
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message{
    /**
     * -1 系统出错,即try catch
     * 0 数据库没有等等即正常失败
     * 1 成功
     */
    int code;
    Object message;
    public Message(int code) {
        this.code = code;
    }

    /**
     * 构造
     * @param code 键值
     * @return 返回信息
     */
    public static Message createMessage(int code){
        return switch (code) {
            case -10 -> Message.builder().code(-1).message("操作失败请稍等").build();
            case -2 -> Message.builder().code(2).message("当前手机号没有此值").build();
            case -1 -> Message.builder().code(0).message("当前数据库没有此值(-1和1用于指定键)").build();
            case 1 -> Message.builder().code(1).message("当前数据库已有此值").build();
            case 2 -> Message.builder().code(3).message("当前手机号已有此值").build();
            case 10 -> Message.builder().code(10).message("成功").build();
            default -> null;
        };
    }

    public boolean getCode(int code){
        return this.code == code;
    }

    /**
     * 构造
     * @param code 键值
     * @param message 传递的类信息
     * @return 返回信息
     */
    public static Message createMessage(int code,Object message){
        return Message.builder().code(code).message(message).build();
    }
}
