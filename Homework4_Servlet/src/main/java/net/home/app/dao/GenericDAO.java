package net.home.app.dao;

import net.home.app.model.Manufacter;
import net.home.app.model.Product;

import java.util.List;

public interface GenericDAO {
    List<Product> getProducts() ;

    Product saveProduct(Product product);

    Product updateProduct (Product product);

    Product deleteProduct(String id);

    List<Product> listProduct()  ;
    void addProduct(List<Product> products);

    List<Manufacter> getManufacters() ;

    Manufacter saveManufacter(Manufacter manufacter);

    Manufacter updateManufacter (Manufacter manufacter);

    Manufacter deleteManufacter(String id);

    List<Manufacter> listManufacter()  ;
    void addManufacter(List<Manufacter> manufacters);

}
