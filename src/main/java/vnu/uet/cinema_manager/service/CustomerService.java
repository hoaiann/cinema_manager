package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Customer;
import vnu.uet.cinema_manager.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository){
        this.customerRepository= customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return  customerRepository.findAll();
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        Optional<Customer> optional= customerRepository.findById(id);
        Customer customer= null;
        if(optional.isPresent()){
            customer= optional.get();
        }else{
            throw new RuntimeException("Customer not found for id: "+ id);
        }
        return customer;
    }

    public void deletCustomerById(Long id){
        customerRepository.deleteById(id);
    }

}
