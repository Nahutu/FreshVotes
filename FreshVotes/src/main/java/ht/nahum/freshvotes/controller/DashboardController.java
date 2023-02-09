package ht.nahum.freshvotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import ht.nahum.freshvotes.domain.Product;
import ht.nahum.freshvotes.domain.User;
import ht.nahum.freshvotes.repository.ProductRepository;

@Controller
public class DashboardController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/")
	public String rootView() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboardView(@AuthenticationPrincipal User user, ModelMap model) {
		List<Product> products = productRepository.findByUser(user);
		model.put("products", products);
		return "dashboard";
	}

}
