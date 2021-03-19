package com.task.taskuniversity.service;

import com.task.taskuniversity.model.Lector;
import com.task.taskuniversity.repository.LectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    private final LectorRepository lectorRepository;

    public LectorService(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }


    public List<Lector> findAllByDepartmentName(String name) {
        List<Lector> lectors = lectorRepository.findAllByDepartmentName(name);
        return lectors;
    }

    public List<Lector> searchByNameLike(String word) {
        List<Lector> lectors = lectorRepository.searchByNameLike(word);
        return lectors;
    }

    public int assistantCount(List<Lector> lectors) {
        int assistantCount = 0;
        for(Lector l : lectors) {
            if(l.getDegree().getName().equals("Assistant")) {
                assistantCount++;
            }
        }
        return assistantCount;
    }
    public int associateProfessorCount(List<Lector> lectors) {
        int associateProfessorCount = 0;
        for(Lector l : lectors) {
            if(l.getDegree().getName().equals("Associate_professor")) {
                associateProfessorCount++;
            }
        }
        return associateProfessorCount;
    }
    public int professorCount(List<Lector> lectors) {
        int professorCount = 0;
        for(Lector l : lectors) {
            if(l.getDegree().getName().equals("Professor")) {
                professorCount++;
            }
        }
        return professorCount;
    }

    public double averageSalary(List<Lector> lectors) {
        double count = 0;
        double sum = 0;
        double average;
        for(Lector l : lectors) {
            count++;
            sum = sum + l.getDegree().getSalary();
        }
        average = sum / count;
        return average;
    }

    public long countAll(List<Lector> lectors) {
        return lectors.stream().count();
    }

}
