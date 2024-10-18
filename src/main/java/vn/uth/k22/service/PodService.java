package vn.uth.k22.service;

import java.util.List;
import java.util.Optional;

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
        List<Pod> pods = this.podRepository.findAll();
        return pods;
    }


    public Pod getPodById(long id) {
        Optional<Pod> podOptional = this.podRepository.findById(id);
            return podOptional.orElse(null); // Trả về null nếu không tìm thấy Pod
    }

    
}
