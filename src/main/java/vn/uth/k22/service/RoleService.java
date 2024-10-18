package vn.uth.k22.service;

import org.springframework.stereotype.Service;

import vn.uth.k22.domain.Role;
import vn.uth.k22.repository.RoleRepository;


@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String name){
        return this.roleRepository.findByName(name);
    }
}
