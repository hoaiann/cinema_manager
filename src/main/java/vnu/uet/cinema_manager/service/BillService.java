package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.repository.BillRepository;

@Service
public class BillService {

    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository){
        this.billRepository= billRepository;
    }
}
