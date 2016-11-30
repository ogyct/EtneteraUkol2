package cz.etn.etnshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.dao.ProductDao;
import cz.etn.etnshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductDao productDao;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam String id) {
        productDao.deleteProduct(Integer.valueOf(id));
        
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;

    }
    
    @RequestMapping("/update")
    public ModelAndView update(@RequestParam String id, @RequestParam String name, @RequestParam String serial) {
        productDao.updateProduct(Integer.valueOf(id), name, serial);
        
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }
    
    @RequestMapping("/insert")
    public ModelAndView insert(@RequestParam String id, @RequestParam String name, @RequestParam String serial) {
        productDao.addProduct(0, name, serial);
        
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productService.getProducts());
        return modelAndView;
    }
    
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String searchText) {
        List<Product> listOfProductsFound = productDao.searchProduct(searchText);
        
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", listOfProductsFound);
        return modelAndView;
    }
}
