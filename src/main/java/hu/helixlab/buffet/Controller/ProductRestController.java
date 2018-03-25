package hu.helixlab.buffet.Controller;

import hu.helixlab.buffet.Domain.Product;
import hu.helixlab.buffet.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/buffet/product/all", method = RequestMethod.GET )
    @CrossOrigin(origins = "http://localhost")
    public Iterable<Product> findAll(){

        return  productService.findAllProduct();
    }

    @RequestMapping (value="/buffet/product", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost")

    public Product createProduct(@RequestBody Product product) {


        return productService.save(product);
    }

    @RequestMapping (value = "buffet/product/{id}", method= RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost")
    public Product updateProductById(@PathVariable ("id") int id, @RequestBody Product product){
        return productService.updateProductById(id, product);

    }

}
