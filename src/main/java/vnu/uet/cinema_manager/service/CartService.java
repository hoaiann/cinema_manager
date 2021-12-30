package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.repository.CartRepository;

@Service
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public void setCartRepository(CartRepository cartRepository){
        this.cartRepository= cartRepository;
    }
}
