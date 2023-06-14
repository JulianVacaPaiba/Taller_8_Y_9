package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Beans.Categories;
import co.edu.sena.project2687351.model.repository.CategoryRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/category-register")
public class CategoryRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String category_name = request.getParameter("category_name");

        // fill it up in a user bean

        Categories categories = new Categories();
        categories.setCategory_name(category_name);

        //todo call repository layer and save the user object to DB
        Repository<Categories> repository = new CategoryRepositoryImpl();
        int rows=0;
        try {
            repository.saveObj(categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //todo procedure an information
        if (rows== 0){
            System.out.println("Ocurrio un error");
        }
        else{
            System.out.println("Registro exitoso");
        }
    }


}
