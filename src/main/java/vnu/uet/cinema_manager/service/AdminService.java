package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Admin;
import vnu.uet.cinema_manager.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository){
        this.adminRepository= adminRepository;
    }

    public List<Admin> getAllAdmin(){
        return  adminRepository.findAll();
    }

    public void saveAdmin(Admin admin){
        adminRepository.save(admin);
    }

    public Admin getAdminById(Long id){
        Optional<Admin> optional= adminRepository.findById(id);
        Admin admin= null;
        if(optional.isPresent()){
            admin= optional.get();
        }else{
            throw new RuntimeException("Admin not found for id: "+ id);
        }
        return admin;
    }

    public void deleteAdminById(Long id){
        adminRepository.deleteById(id);
    }
}
