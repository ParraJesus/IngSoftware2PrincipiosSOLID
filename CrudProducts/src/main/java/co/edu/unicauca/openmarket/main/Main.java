
package co.edu.unicauca.openmarket.main;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.presentation.GUIProducts;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IProductRepository repository = Factory.getInstance().getProductRepository("default");
        ProductService productService = new ProductService(repository);
        
        ICategoryRepository catRepository = Factory.getInstance().getCategoryRepository("default");
        CategoryService categoryService = new CategoryService(catRepository);
        
        GUIProducts instance = new GUIProducts(productService, categoryService);
        instance.setVisible(true);
    }
    
}
