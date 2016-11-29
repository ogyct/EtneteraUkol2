package cz.etn.etnshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {
    private final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProducts() {
        Criteria criteria = getSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    @Override
    public Product addProduct(int id, String name, String serial) {
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setSerial(serial);
        getSession().save(p);
        logger.debug("Inserted " + p);
        return p;
    }

    @Override
    public Product updateProduct(int id, String name, String serial) {
        Product p = (Product) getSession().get(Product.class, id);
        p.setName(name);
        p.setSerial(serial);
        getSession().save(p);
        logger.debug("Saved " + p);
        return p;
    }

    @Override
    public Product deleteProduct(int id) {
        //Transaction tx = getSession().getTransaction();
        Product p = (Product) getSession().get(Product.class, id);
        getSession().delete(p);
        logger.debug("Deleted " + p);
        return p;
    }

}
