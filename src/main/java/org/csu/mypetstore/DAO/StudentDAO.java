package org.csu.mypetstore.DAO;

import org.csu.mypetstore.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student,Integer> {
}
