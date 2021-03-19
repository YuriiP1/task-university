package com.task.taskuniversity.repository;

import com.task.taskuniversity.model.Department;
import com.task.taskuniversity.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query(value = "SELECT l1 FROM Lector l1 JOIN l1.departments l2 WHERE l2.name = :name")
    List<Lector> findAllByDepartmentName(@Param("name") String name);

    @Query(value = "SELECT l FROM Lector l WHERE l.name LIKE %:word%")
    List<Lector> searchByNameLike(@Param("word") String word);
}
