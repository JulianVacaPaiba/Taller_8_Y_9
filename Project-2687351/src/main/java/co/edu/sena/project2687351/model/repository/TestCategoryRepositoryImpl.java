package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Beans.Categories;

import java.sql.SQLException;

public class TestCategoryRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<Categories> repository = new CategoryRepositoryImpl();
        System.out.println("=============== saveObj Insert ===============");
        Categories categoriesInsert = new Categories();
        categoriesInsert.setCategory_name("Bebidas");
        repository.saveObj(categoriesInsert);
        categoriesInsert.setCategory_name("Papas");
        repository.saveObj(categoriesInsert);

        System.out.println("=============== listAllObj ===============");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=============== byIdObj ===============");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("=============== saveObj ===============");
        Categories categoriesUpdate = new Categories();
        categoriesUpdate.setCategory_id(1);
        categoriesUpdate.setCategory_name("Frituras");
        repository.saveObj(categoriesUpdate);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=============== deleteObj ===============");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }
}
