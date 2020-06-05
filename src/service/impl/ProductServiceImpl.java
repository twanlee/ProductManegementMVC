package service.impl;

import model.Product;
import model.concrete.MobilePhone;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new MobilePhone(1,"Nokia 1",2000000,"Nokia"));
        products.put(2,new MobilePhone(2,"Nokia 2",2000000,"Nokia"));
        products.put(3,new MobilePhone(3,"Nokia 3",2000000,"Nokia"));
        products.put(4,new MobilePhone(4,"Nokia 4",2000000,"Nokia"));
        products.put(5,new MobilePhone(5,"Nokia 5",2000000,"Nokia"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findByID(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
