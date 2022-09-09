package wn.yy.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wn.yy.demo.Dao.UserDao;
import wn.yy.demo.entity.User;

@Service
public class UserService {
    @Autowired
    UserDao userDao;


    /**
     * 添加学号数据
     * @param student 学号
     * @return 是否添加成功
     */
    public boolean addUser(String student){
        if(reaUser(student))//如果存在说明出现了问题
            return false;
        User user1 = new User();
        user1.setStudent(student);
        try{
            userDao.save(user1);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 删除
     * @param student 学号
     * @return true删除成功 false删除失败
     */
    public boolean delUser(String student){
        if(!reaUser(student))//如果不存在那么删除不了
            return false;
        try{
            userDao.deleteByStudent(student);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 激活注册
     * @param user 学生信息
     */
    public boolean active(User user){
        //激活了
        user.setActive(1);
        try {
            userDao.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 搜索学号是否存在
     * @param student 学号
     * @return true为存在,false为不存在
     */
    public boolean reaUser(String student){
        return userDao.findByStudent(student) != null;
    }

    /**
     * 查找特定的student
     * @param student 学号
     * @return 查找的值
     */
    public User searchUser(String student){
        try{
            return userDao.findByStudent(student);
        }catch (Exception e){
            return null;
        }
    }
}
