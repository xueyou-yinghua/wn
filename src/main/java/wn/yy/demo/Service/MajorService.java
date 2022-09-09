package wn.yy.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wn.yy.demo.Dao.MajorDao;
import wn.yy.demo.entity.Major;
import java.util.List;

@Service
public class MajorService {
    @Autowired
    MajorDao majorDao;
    //代码目前最长长度为7给他前面补0
    int length = 7;

    /**
     * 获取专业名称的代码
     * @param name 专业名称
     * @return 代码
     */
    public String getCode(String name) {
        //获取代码
        StringBuilder code = new StringBuilder(majorDao.findByName(name).getCode());
        while(code.length()!=length){
            code.insert(0, "0");
        }
        return code.toString();
    }

    /**
     * 所有数据
     * @return 所有数据
     */
    public List<Major> findAll(){
        return majorDao.findAll();
    }
}
