package wn.yy.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wn.yy.demo.Dao.UserDao;

@Service
public class UserService {
    @Autowired
    UserDao userDao;


}
