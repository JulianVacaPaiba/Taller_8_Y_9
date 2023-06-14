package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Beans.Products;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepositoryImpl implements Repository<Products> {
    private String sql= null;
    @Override
    public List<Products> listAllObj() throws SQLException {
        sql="select product_id, product_name, product_value,category_id" +
                " from products_tbl";
        List<Products> products =new ArrayList<>();
        try(Connection conn= ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Products u = createObj(rs);
                products.add(u);
            }
        }
        return products;
    }

    @Override
    public Products byIdObj(Integer id) throws SQLException {
        sql = "select u.product_id, u.product_name,u.product_value,u.category_id"+
                " from products_tbl u where u.product_id= ? ";
        Products products = null;

        try (Connection conn= ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    products = createObj(rs);
                }
            }
        }
        return products;
    }

    @Override
    public Integer saveObj(Products products) throws SQLException {
        int rowsAffected = 0;
        if(products.getProduct_id() !=null && products.getProduct_id()>0){
            sql = "update products_tbl set product_name = ?,product_value= ?,category_id = ? " +
                    "where product_id = ?";
        }else {
            sql = "insert into products_tbl (product_name,product_value,category_id)" +
                    "values ((?),(?),(?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setString(1,products.getProduct_name());
            ps.setInt(2,products.getProduct_value());
            ps.setInt(3,products.getCategory_id());
            if (products.getProduct_id() !=null && products.getProduct_id()>0){
                ps.setInt(4,products.getProduct_id());
            }
            rowsAffected= ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from products_tbl where product_id=?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Products createObj(ResultSet rs) throws SQLException {
        Products products = new Products();
        products.setProduct_id(rs.getInt("product_id"));
        products.setProduct_name(rs.getString("product_name"));
        products.setProduct_value(rs.getInt("product_value"));
        products.setCategory_id(rs.getInt("category_id"));
        return products;
    }
}
