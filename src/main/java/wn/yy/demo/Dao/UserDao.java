package wn.yy.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import wn.yy.demo.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByStudent(String student);

    @Transactional
    void deleteByStudent(String student);
}
