package wn.yy.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wn.yy.demo.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {
}
