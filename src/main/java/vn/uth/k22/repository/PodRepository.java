package vn.uth.k22.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import vn.uth.k22.domain.Pod;

public interface PodRepository extends JpaRepository<Pod, Long> {
   
    Optional<Pod> findById(Long id);
   
  
    @Override
    List<Pod> findAll();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pods WHERE id = :id", nativeQuery = true)
    void deleteById(long id);
}
