package crudapp.dao;

import java.util.List;

import crudapp.model.Product;

public interface ProductDao {
	public void create(Product product);
	public List<Product> getAllProducts();
	public void delete(int pId);
	public Product getProduct(int pId);
}
