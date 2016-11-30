package cz.etn.etnshop.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface ProductDao {

	@Transactional(readOnly = true)
	List<Product> getProducts();
	@Transactional
	Product addProduct(int id, String name, String serial);
	@Transactional
	Product updateProduct(int id, String name, String serial);
	@Transactional
	Product deleteProduct(int id);
	@Transactional
	List<Product> searchProduct(String searchString);

}
