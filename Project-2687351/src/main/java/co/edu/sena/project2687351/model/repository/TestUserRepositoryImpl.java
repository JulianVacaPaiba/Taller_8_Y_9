package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Beans.User;

import java.sql.SQLException;

public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepositoryImpl();
        System.out.println("=============== saveObj Insert ===============");
        User userInsert = new User();
        userInsert.setUser_firstname("cARlos");
        userInsert.setUser_lastname("rojas");
        userInsert.setUser_email("carlos@loquesea.com");
        userInsert.setUser_password("dsfafsadada");
        repository.saveObj(userInsert);
        userInsert.setUser_firstname("Sofia");
        userInsert.setUser_lastname("perez");
        userInsert.setUser_email("cdsdsadsa@loquesea.com");
        userInsert.setUser_password("fsafsdsadsa");
        repository.saveObj(userInsert);

        System.out.println("=============== listAllObj ===============");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=============== byIdObj ===============");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("=============== saveObj ===============");
        User userUpdate = new User();
        userUpdate.setUser_id(1);
        userUpdate.setUser_firstname("Jorge");
        userUpdate.setUser_lastname("Palacios");
        userUpdate.setUser_email("jorge@loquese.com");
        userUpdate.setUser_password("dasfasfvsa2421");
        repository.saveObj(userUpdate);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=============== deleteObj ===============");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }
}
