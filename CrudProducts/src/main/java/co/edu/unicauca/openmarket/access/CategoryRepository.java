package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Parra
 */
public class CategoryRepository implements ICategoryRepository{
    
    private Repository repos = new Repository();
    
    public CategoryRepository()
    {
        String sql = "CREATE TABLE IF NOT EXISTS categories (\n"
                + "	categoryId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL\n"
                + ");";
        
        repos.initDatabase(sql);
    }

    @Override
    public boolean save(Category newCategory) {
        try {
            //Validate product
            if (newCategory == null || newCategory.getName().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO categories ( name ) "
                    + "VALUES ( ?)";

            PreparedStatement pstmt = repos.getConn().prepareStatement(sql);
            pstmt.setString(1, newCategory.getName());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean edit(long id, Category category) 
    {
        try {
            //Validate product
            if (id <= 0 || category == null) {
                return false;
            }
            //this.connect();

            String sql = "UPDATE  categories "
                    + "SET name=?"
                    + "WHERE categoryId = ?";

            PreparedStatement pstmt = repos.getConn().prepareStatement(sql);
            pstmt.setString(1, category.getName());
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        try {
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM categories "
                    + "WHERE categoryId = ?";

            PreparedStatement pstmt = repos.getConn().prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {

            String sql = "SELECT * FROM categories";
            //this.connect();

            Statement stmt = repos.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Category newCategory = new Category();
                newCategory.setCategoryId(rs.getLong("categoryId"));
                newCategory.setName(rs.getString("name"));

                categories.add(newCategory);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public Category findById(Long id) {
        try {

            String sql = "SELECT * FROM categories  "
                    + "WHERE categoryId = ?";

            PreparedStatement pstmt = repos.getConn().prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Category cat = new Category();
                cat.setCategoryId(res.getLong("categoryId"));
                cat.setName(res.getString("name"));
                return cat;
            } else {
                return null;
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
