package vn.uth.k22.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.uth.k22.domain.Role;



public interface RoleRepository extends JpaRepository<Role, Long>  {
    
    @Override
    List<Role> findAll();
    Role findById(long id);
    
    Role findByName(String name);
}
