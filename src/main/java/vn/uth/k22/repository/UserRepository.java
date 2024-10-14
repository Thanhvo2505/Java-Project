package vn.uth.k22.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.uth.k22.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Các phương thức tùy chỉnh có thể được định nghĩa ở đây
    @Override
    List<User> findAll();
}