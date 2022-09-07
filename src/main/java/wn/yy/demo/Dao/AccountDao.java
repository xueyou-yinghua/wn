package wn.yy.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wn.yy.demo.entity.Account;

public interface AccountDao extends JpaRepository<Account,String> {
}
