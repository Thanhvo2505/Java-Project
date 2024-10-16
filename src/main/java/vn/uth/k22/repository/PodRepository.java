package vn.uth.k22.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.uth.k22.domain.Pod;



public interface PodRepository extends JpaRepository<Pod, Long>  {
    
    @Override
    List<Pod> findAll();

    Pod findById(long id);

    @Override
    Pod save(Pod pod);
}
