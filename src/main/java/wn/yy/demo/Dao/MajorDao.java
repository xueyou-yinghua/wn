package wn.yy.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import wn.yy.demo.entity.Major;

public interface MajorDao extends JpaRepository<Major,String> {
    Major findByName(String name);
}
