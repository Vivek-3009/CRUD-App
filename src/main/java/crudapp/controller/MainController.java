package crudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudapp.model.Product;
import crudapp.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("product", products);
		return "home";
	}
	
	//show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	//handle add product form
	@RequestMapping(path="/handle-product",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productService.create(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
}
