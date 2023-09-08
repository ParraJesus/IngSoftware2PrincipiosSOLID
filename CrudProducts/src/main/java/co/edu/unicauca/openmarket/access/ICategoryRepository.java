package co.edu.unicauca.openmarket.access;

import java.util.List;
import java.util.Locale.Category;

/**
 *
 * @author Jesus Parra
 */
public interface ICategoryRepository {
    
    boolean save(Category newCategory);
    
    boolean edit(long categoryId, Category category);
    
    boolean delete(long categoryId);
    
    List<Category> findAll();
}
