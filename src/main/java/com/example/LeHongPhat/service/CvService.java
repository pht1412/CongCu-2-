package com.example.LeHongPhat.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.LeHongPhat.model.Cv;
import com.example.LeHongPhat.repository.CvRepository;


@Service
public class CvService {

    private final CvRepository repo;

    public CvService(CvRepository repo){
        this.repo = repo;
    }

    public Cv save(Cv cv){
        return repo.save(cv);
    }

    public List<Cv> getAll(){
        return repo.findAll();
    }
}
