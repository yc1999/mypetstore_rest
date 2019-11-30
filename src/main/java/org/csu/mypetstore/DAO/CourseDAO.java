package org.csu.mypetstore.DAO;

import org.csu.mypetstore.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course,Integer> {
}
