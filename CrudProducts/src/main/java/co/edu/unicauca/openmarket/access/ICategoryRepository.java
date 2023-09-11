package co.edu.unicauca.openmarket.access;

import java.util.List;
import co.edu.unicauca.openmarket.domain.Category;

/**
 *
 * @author Jesus Parra
 */
public interface ICategoryRepository {
    
    boolean save(Category newCategory);
    
    boolean edit(long id, Category category);
    
    boolean delete(long id);
    
    Category findById(Long id);
    
    List<Category> findAll();
}
