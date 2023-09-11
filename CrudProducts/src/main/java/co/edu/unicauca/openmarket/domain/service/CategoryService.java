package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Parra
 */
public class CategoryService {
    
    private ICategoryRepository repository;
    
    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }
    
    public boolean saveCategory(String name) {
        
        Category newCategory = new Category();
        newCategory.setName(name);
        
        if (newCategory.getName().isBlank() ) {
            return false;
        }

        return repository.save(newCategory);
    }
    
    public Category findCategoryById(Long id){
        return repository.findById(id);
    }
    
    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<>();
        categories = repository.findAll();;

        return categories;
    }
    
    public boolean deleteCategory(Long id){
        return repository.delete(id);
    }

    public boolean editCategory(Long productId, Category prod) {
        
        //Validate product
        if (prod == null || prod.getName().isBlank() ) {
            return false;
        }
        return repository.edit(productId, prod);
    }
    
}
