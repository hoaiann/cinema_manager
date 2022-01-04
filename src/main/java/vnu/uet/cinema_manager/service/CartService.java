package vnu.uet.cinema_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.cinema_manager.entity.Cart;
import vnu.uet.cinema_manager.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public void setCartRepository(CartRepository cartRepository){
        this.cartRepository= cartRepository;
    }

    public List<Cart> getAllCart(){
        return  cartRepository.findAll();
    }

    public void saveCart(Cart cart){
        // cart.setActive(true);
        cartRepository.save(cart);
    }

    public Cart getCartById(Long id){
        Optional<Cart> optional= cartRepository.findById(id);
        Cart cart= null;
        if(optional.isPresent()){
            cart= optional.get();
        }
        return cart;
    }

    public void deleteCartById(Long id){
        cartRepository.deleteById(id);
    }
}
