package crudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crudapp.model.Product;

@Repository
public class ProductDaoImp implements ProductDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create

	@Transactional
	public void create(Product product) {
		this.hibernateTemplate.save(product);
		
	}
	
	//get all products
	
	public List<Product> getAllProducts() {
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete single product
	
	@Transactional
	public void delete(int pId) {
		Product p =this.hibernateTemplate.load(Product.class, pId);
		this.hibernateTemplate.delete(p);
		
	}
	
	//get single product

	public Product getProduct(int pId) {
		Product product =this.hibernateTemplate.load(Product.class, pId);
		return product;
	}

}
