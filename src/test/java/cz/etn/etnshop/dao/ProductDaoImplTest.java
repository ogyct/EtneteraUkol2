package cz.etn.etnshop.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-core-config.xml" })

public class ProductDaoImplTest {
    @Autowired
    private ProductDao productDao;

    //    @Before
    //    public void setUp() throws Exception {
    //    }
    //
    //    @Test
    //    public void testGetProducts() {
    //        fail("Not yet implemented");
    //    }
    //
    @Test
    public void testAddProduct() {
        productDao.addProduct(0, "junit insert", "iiiii");
        System.out.println("Success");
    }

    //
    @Test
    public void testUpdateProduct() {
        productDao.updateProduct(1, "Junit update", "uuuuu");
        System.out.println("Success");
    }

    //    @Test
    //    public void testDeleteProduct() {
    //
    //        productDao.deleteProduct(7);
    //
    //        System.out.println("Success");
    //    }

}
