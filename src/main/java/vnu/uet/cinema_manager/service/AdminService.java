package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.repository.AdminRepository;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository){
        this.adminRepository= adminRepository;
    }

}
