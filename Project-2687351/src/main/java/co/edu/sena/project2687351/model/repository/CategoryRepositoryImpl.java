package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Beans.Categories;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository <Categories> {
private String sql= null;
    @Override
    public List<Categories> listAllObj() throws SQLException {
        sql="select category_id, category_name" +
                " from categories_tbl ";
        List<Categories> categories =new ArrayList<>();
        try(Connection conn= ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Categories u = createObj(rs);
                categories.add(u);
            }
        }
        return categories;
    }

    @Override
    public Categories byIdObj(Integer id) throws SQLException {
        sql = "select u.category_id, u.category_name"+
                " from categories_tbl u where u.category_id= ? ";
        Categories categories = null;

        try (Connection conn= ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    categories = createObj(rs);
                }
            }
        }
        return categories;
    }

    @Override
    public Integer saveObj(Categories categories) throws SQLException {
        int rowsAffected = 0;
        if(categories.getCategory_id() !=null && categories.getCategory_id()>0){
            sql = "update categories_tbl set category_name = ?" +
                    "where category_id = ?";
        }else {
            sql = "insert into categories_tbl (category_name)" +
                    "values ((?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setString(1,categories.getCategory_name());
            if (categories.getCategory_id() !=null && categories.getCategory_id()>0){
                ps.setInt(2,categories.getCategory_id());
            }
            rowsAffected= ps.executeUpdate();
        }
        return rowsAffected;
    }
    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from categories_tbl where category_id=?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Categories createObj(ResultSet rs) throws SQLException {
        Categories categories = new Categories();
        categories.setCategory_id(rs.getInt("category_id"));
        categories.setCategory_name(rs.getString("category_name"));
        return categories;
    }
}
