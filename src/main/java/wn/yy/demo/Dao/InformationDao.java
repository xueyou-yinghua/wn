package wn.yy.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import wn.yy.demo.entity.Information;

public interface InformationDao extends JpaRepository<Information,String> {
    Information getByStudent(String student);

    @Transactional
    void deleteByStudent(String student);
}
