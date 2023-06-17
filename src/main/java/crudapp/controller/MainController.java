package crudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//handle add and update product form using redirect in return
	@RequestMapping(path="/handle-product",method = RequestMethod.POST)
	public String handleProduct(@ModelAttribute Product product) {
		System.out.println(product);
		productService.create(product);
		return "redirect:/";
	}
	
	//delete handler using RedirectView
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int pId, HttpServletRequest request) {
		this.productService.delete(pId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//update-form handler
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int pId,Model model) {
		Product product = this.productService.getProduct(pId);
		model.addAttribute("product", product);
		return "update_form";
		
	}	
}
