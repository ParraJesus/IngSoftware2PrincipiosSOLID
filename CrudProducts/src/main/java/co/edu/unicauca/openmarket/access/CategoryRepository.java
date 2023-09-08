package co.edu.unicauca.openmarket.access;

import java.util.List;
import java.util.Locale;

/**
 *
 * @author Jesus Parra
 */
public class CategoryRepository implements ICategoryRepository{

    @Override
    public boolean save(Locale.Category newCategory) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean edit(long categoryId, Locale.Category category) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(long categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Locale.Category> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
