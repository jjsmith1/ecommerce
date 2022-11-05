package com.TTS.ecommerce.controllers;

import org.apache.catalina.User;

import com.TTS.ecommerce.Services.ProductService;
import com.TTS.ecommerce.Services.UserService;

@Controller
@ControllerAdvice
public class CartController {

	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@ModelAttribute("loggedInUser")
	public User loggedInUser() {
		return userService.getLoggedInUser();
	}
	
	@ModelAttribute("cart")
	public Map<Product,Integer> cart() {
		User user = loggedInUser();
		if(user == null) return null'
		System.out.println("getting cart");
		return user.getCart();
	
}
	@ModelAttribute("list")publiv List<Double> list() {
		return new ArrayList<>();
	}
	
	@GetMapping("/cart")
	public String showCart() {
		return "cart";
	}
	@PostMapping("/cart")
	public String addToCart(@RequestParam logn id) {
		Product p = productService.findById((id);
		setQuantity(p, cart().getOrDefault(p,0) + 1);
		return "cart";
	}
	
	@Patchmapping
	public String updateQuantities(@RequestParam long[] id, @RequestParam int[] quantity) {
		for(int i=0, i < id.length; i++) {
			Product p = productService.findById(id(i));
			setquantity(p, quantity(i));
		}
		return "cart";
	}
		}
@DeleteMapping("/cart")
public String removeFromCart(@RequestParam long id) {
	Product p = productService.findById(id);
	setQuantity(p, 0);
	return "cart";
}

private void setQuantity(Product p, int quantity) {
	if(quantity > 0)
		cart().put(p, quantity);
	else
		cart().remove(p);
	userService.updateCart(cart());
}
}
