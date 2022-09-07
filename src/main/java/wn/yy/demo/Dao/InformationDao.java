package wn.yy.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wn.yy.demo.entity.Information;

public interface InformationDao extends JpaRepository<Information,String> {
}
