package vn.uth.k22.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.uth.k22.domain.Pod;
import vn.uth.k22.repository.PodRepository;


@Service
public class PodService {
    private final PodRepository podRepository;

    public PodService(PodRepository podRepository) {
        this.podRepository = podRepository;
    }
    
    public List<Pod> getAllPod(){
        return this.podRepository.findAll();
    }


    
}
