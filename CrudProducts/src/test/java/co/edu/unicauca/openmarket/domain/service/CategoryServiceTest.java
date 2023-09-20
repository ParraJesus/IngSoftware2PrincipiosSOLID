package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.access.IRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jesus
 */
public class CategoryServiceTest {
    
    private ICategoryRepository repositoryCategory = Factory.getInstance().getCategoryRepository("default");
    private CategoryService categoryService =  new CategoryService(repositoryCategory);
    
    
    //ICategoryRepository catRepository = Factory.getInstance().getCategoryRepository("default");
    //    CategoryService categoryService = new CategoryService(catRepository);
    public CategoryServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveCategory method, of class CategoryService.
     */
    @Test
    public void testSaveCategory() {
        System.out.println("saveCategory");

        Category categoria = new Category();
        categoria.setCategoryId((long)1);
        categoria.setName("Limpieza");

        boolean guardar = categoryService.saveCategory(categoria.getName());
        assertTrue(guardar); 
    }

    /**
     * Test of findCategoryById method, of class CategoryService.
     */
    @Test
    public void testFindCategoryById() {
        System.out.println("findCategoryById"); 
        
        Category categoria = new Category();
        categoria.setCategoryId((long)1);
        categoria.setName("Limpieza");

        boolean guardar = categoryService.saveCategory(categoria.getName());
        assertTrue(guardar); 

        Long categoryId = categoria.getCategoryId();
        assertNotNull(categoryId);

        Category encontrarCategoria = categoryService.findCategoryById(categoryId);

        assertNotNull(encontrarCategoria);
        assertEquals("Limpieza", encontrarCategoria.getName());
    }

    /**
     * Test of findAllCategories method, of class CategoryService.
     */
    @Test
    public void testFindAllCategories() {
        System.out.println("findAllCategories");
        
        Category cat1 = new Category();
        cat1.setCategoryId((long)1);
        cat1.setName("Limpieza");
        
        Category cat2 = new Category();
        cat2.setCategoryId((long)2);
        cat2.setName("Electrodomésticos");

        boolean save1 = categoryService.saveCategory(cat1.getName());
        boolean save2 = categoryService.saveCategory(cat2.getName());
        
        assertTrue(save1); 
        assertTrue(save2);

        List<Category> listaCategorias = categoryService.findAllCategories();      
        assertNotNull(listaCategorias);
        assertEquals(2, listaCategorias.size());

        Object firstCatIndex = listaCategorias.get(0);
        Object secondCatIndex = listaCategorias.get(1);

        assertTrue(firstCatIndex instanceof Category);
        assertTrue(secondCatIndex instanceof Category);

        Category categoriaEncontrada1 = (Category) firstCatIndex;
        Category categoriaEncontrada2 = (Category) secondCatIndex;

        assertEquals("Limpieza", categoriaEncontrada1.getName());
        assertEquals("Electrodomésticos", categoriaEncontrada2.getName());
    }

    /**
     * Test of deleteCategory method, of class CategoryService.
     */
    @Test
    public void testDeleteCategory() {
        System.out.println("deleteCategory");
        
        Category categoria = new Category();
        categoria.setCategoryId((long)1);
        categoria.setName("Electrodomésticos");

        boolean saved = categoryService.saveCategory(categoria.getName());
        assertTrue(saved); 

        Long categoryId = categoria.getCategoryId();
        assertNotNull(categoryId);

        boolean deleted = categoryService.deleteCategory(categoryId);
        assertTrue(deleted);

        Category deletedCat = categoryService.findCategoryById(categoryId);
        assertNull(deletedCat);
    }

    /**
     * Test of editCategory method, of class CategoryService.
     */
    @Test
    public void testEditCategory() {
        System.out.println("editCategory");
        
        Category categoria = new Category();
        categoria.setCategoryId(1L);
        categoria.setName("Electrodomésticos");

        boolean save = categoryService.saveCategory(categoria.getName());
        assertTrue(save); 

        categoria.setName("Limpieza");
        
        boolean editar = categoryService.editCategory(categoria.getCategoryId(), categoria);
        assertTrue(editar); 
        
        Category foundCategory = categoryService.findCategoryById((long) 1);
        
        assertNotNull(foundCategory);
        assertEquals(1, foundCategory.getCategoryId());
        
        System.out.println("Producto:\n"+foundCategory.getName());
    }
    
}
