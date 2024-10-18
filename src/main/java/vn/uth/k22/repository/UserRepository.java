package vn.uth.k22.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.uth.k22.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Các phương thức tùy chỉnh có thể được định nghĩa ở đây
  
    @Override
    @Query(value = "select * from users ORDER BY role_id", nativeQuery = true)
    List<User> findAll();

    User findById(long id);
    void deleteById(long id);

}