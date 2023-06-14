package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Beans.Products;
import co.edu.sena.project2687351.model.repository.ProductsRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/product-register")
public class ProductRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String product_name= request.getParameter("product_name");
        Integer product_value = Integer.valueOf(request.getParameter("product_value"));
        Integer category_id = Integer.valueOf(request.getParameter("category_id"));

        Products products = new Products();
        products.setProduct_name(product_name);
        products.setProduct_value(product_value);
        products.setCategory_id(category_id);

        //todo call repository layer and save the user object to DB
        Repository<Products> repository = new ProductsRepositoryImpl();
        int rows=0;
        try {
            repository.saveObj(products);
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
