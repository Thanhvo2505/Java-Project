package vn.uth.k22.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.uth.k22.domain.Pod;

public interface PodRepository extends JpaRepository<Pod, Long> {
   
    Optional<Pod> findById(Long id);
   
  
    @Override
    List<Pod> findAll();
}
