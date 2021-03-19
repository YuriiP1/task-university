package com.task.taskuniversity.repository;

import com.task.taskuniversity.model.Department;
import com.task.taskuniversity.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);

    @Query(value = "SELECT d FROM Department d WHERE d.name LIKE %:word%")
    List<Department> searchByNameLike(@Param("word") String word);
}
