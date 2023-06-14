package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Beans.Products;

import java.sql.SQLException;

public class TestProductsRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<Products> repository = new ProductsRepositoryImpl();
        System.out.println("=============== saveObj Insert ===============");
        Products productsInsert = new Products();
        productsInsert.setProduct_name("Agua");
        productsInsert.setProduct_value(1000);
        productsInsert.setCategory_id(1);
        repository.saveObj(productsInsert);
        productsInsert.setProduct_name("Cocacola");
        productsInsert.setProduct_value(2000);
        productsInsert.setCategory_id(1);

        repository.saveObj(productsInsert);

        System.out.println("=============== listAllObj ===============");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=============== byIdObj ===============");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("=============== saveObj ===============");
        Products productsUpdate = new Products();
        productsUpdate.setProduct_id(1);
        productsUpdate.setProduct_name("Pepsi");
        productsUpdate.setProduct_value(2100);
        productsUpdate.setCategory_id(1);
        repository.saveObj(productsUpdate);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=============== deleteObj ===============");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }
}
