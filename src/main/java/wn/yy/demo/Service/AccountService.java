package wn.yy.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wn.yy.demo.Dao.AccountDao;
import wn.yy.setup.Message;
import wn.yy.demo.entity.Account;

@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;

    /**
     * 添加
     * @param account 账号密码
     * @return 10添加成功,2已有电话号码,1已有信息,-10系统错误,
     */
    public Message addAccount(Account account){
        try{
            Message message = reaAccount(account.getStudent());
            Message message1 = reaPhone(account.getPhone());
            if(message.getCode(1))//有了就不能添加
                return Message.createMessage(1);
            else if (message.getCode(0))//报错
                return Message.builder().code(-10).build();

            if(message1.getCode(1))//有了电话号码就不能添加
                return Message.createMessage(2);
            else if (message1.getCode(0))//报错
                return Message.builder().code(-10).build();
            accountDao.save(account);
            return Message.builder().code(10).build();
        }catch (Exception e){
            return Message.builder().code(-10).build();
        }
    }

    /**
     * 删除学生注册登录 通过学号
     * @param student 学号
     * @return 10删除成功 -1没有该信息 -10系统
     */
    public Message delAccount(String student){
        try{
            Message message = reaAccount(student);
            if(message.getCode(-1))//没有了就不能删除
                return Message.createMessage(-1);
            else if (message.getCode(0))//报错
                return Message.builder().code(-10).build();

            accountDao.deleteByStudent(student);
            return Message.builder().code(10).build();
        }catch (Exception e){
            return Message.builder().code(-10).build();
        }
    }

    /**
     * 删除学生信息通过手机号
     * @param phone 手机号
     * @return 10是删除，-2是没有手机号，-10是系统
     */
    public Message deleteAccount(String phone){
        try{
            Message message = reaPhone(phone);
            if(message.getCode(-1))//没有了电话号码就不能添加
                return Message.createMessage(-2);
            else if (message.getCode(0))//报错
                return Message.builder().code(-10).build();
            accountDao.deleteByPhone(phone);
            return Message.builder().code(10).build();
        }catch (Exception e){
            return Message.builder().code(-10).build();
        }
    }

    /**
     * 搜索是否有这个学生信息
     * @param student 学号
     * @return 1是有，-1是没有，0是系统
     */
    public Message reaAccount(String student){
        try{
            //不为空就是1，空就是0
            return Message.builder().code(accountDao.findByStudent(student)!=null?1:-1).build();
        }catch(Exception e){
            return Message.builder().code(0).build();
        }
    }

    /**
     * 搜索是否有这个学生信息
     * @param phone 手机号
     * @return 1是有，-1是没有，0是系统
     */
    public Message reaPhone(String phone){
        try{
            //不为空就是1，空就是0
            return Message.builder().code(accountDao.findByStudent(phone)!=null?1:-1).build();
        }catch(Exception e){
            return Message.builder().code(0).build();
        }
    }
}
