package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Bill;
import vnu.uet.cinema_manager.repository.BillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository){
        this.billRepository= billRepository;
    }

    public List<Bill> getAllBill(){
        return  billRepository.findAll();
    }

    public void saveBill(Bill bill){
        // bill.setActive(true);
        billRepository.save(bill);
    }

    public Bill getBillById(Long id){
        Optional<Bill> optional= billRepository.findById(id);
        Bill bill= null;
        if(optional.isPresent()){
            bill= optional.get();
        }else{
            throw new RuntimeException("Bill not found for id: "+ id);
        }
        return bill;
    }

    public void deleteBillById(Long id){
        billRepository.deleteById(id);
    }
}
