package hu.helixlab.buffet.Service;


import hu.helixlab.buffet.Domain.Product;
import hu.helixlab.buffet.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAllProduct () {
        return productRepository.findAll();
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product updateProductById (int id, Product newProduct){
        Product oldProduct = productRepository.findOne(id);

        oldProduct.setProductName(newProduct.getProductName());
        oldProduct.setProductPrice(newProduct.getProductPrice());
        return productRepository.save(oldProduct);

    }

}
