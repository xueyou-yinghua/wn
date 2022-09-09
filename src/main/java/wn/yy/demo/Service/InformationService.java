package wn.yy.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wn.yy.demo.Dao.InformationDao;
import wn.yy.demo.entity.Information;
import wn.yy.setup.Message;

@Service
public class InformationService {
    @Autowired
    InformationDao informationDao;

    /**
     * 增加学生信息
     * @param information 学生总体信息类
     * @return 是否添加成功 10添加成功 1有此信息 -10系统错误
     */
    public Message addInformation(Information information){
        try{
            Message message = reaInformation(information.getStudent());
            if(message.getCode(1))//说明数据库有了那就不能添加了
                return Message.createMessage(1);
            else if(message.getCode(-1)){//没有可以添加
                informationDao.save(information);
                return Message.createMessage(10);
            }
            return Message.createMessage(-10);
        }catch (Exception e){
            return Message.createMessage(-10);
        }
    }

    /**
     * 删除
     * @param student 学号
     * @return 删除是否成功 10删除成功 -1没有数据 -10系统错误
     */
    public Message removeInformation(String student){
        try{
            Message message = reaInformation(student);
            if(message.getCode(-1))//说明数据库没有，那就不能删除
                return Message.createMessage(-1);
            else if(message.getCode(1)){//如果有那就可以删除
                informationDao.deleteByStudent(student);
                return Message.createMessage(10);
            }
            return Message.createMessage(-10);
        }catch (Exception e){
            return Message.createMessage(-10);
        }
    }

    /**
     * 修改信息
     * @param information 整个信息
     * @return 是否修改成功
     */
    public boolean updateInformation(Information information){
        return true;
    }

    /**
     * 修改信息
     * @param student 学号
     * @return 是否修改成功
     */
    public boolean updateInformation(String student){

        return true;
    }

    /**
     * 获取数据
     * @param student 学号
     * @return 数据
     */
    public Information getInformation(String student){
        try{
            return informationDao.getByStudent(student);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * 查询是否存在这个学号
     * @param student 学号
     * @return 1为有，-1为无，0系统报错
     */
    public Message reaInformation(String student){
        try{
            boolean result = informationDao.getByStudent(student) != null;
            return Message.createMessage(result?1:-1);
        }catch(Exception e){
            return Message.createMessage(0);
        }
    }
}
