package crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudapp.dao.ProductDaoImp;
import crudapp.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDaoImp daoImp;
	
	public void create(Product product) {
		this.daoImp.create(product);
	}

	public List<Product> getAllProducts(){
		return this.daoImp.getAllProducts();
	}
}
