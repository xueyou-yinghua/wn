package wn.yy.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import wn.yy.demo.entity.Account;

public interface AccountDao extends JpaRepository<Account,String> {
    Account findByStudent(String student);

    Account findByPhone(String phone);

    @Transactional
    void deleteByStudent(String student);

    @Transactional
    void deleteByPhone(String phone);

}
