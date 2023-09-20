package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.Factory;
import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
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
public class ProductServiceTest {
    
    IProductRepository repository = Factory.getInstance().getProductRepository("default");
    ProductService productService = new ProductService(repository);
        
    ICategoryRepository catRepository = Factory.getInstance().getCategoryRepository("default");
    CategoryService categoryService = new CategoryService(catRepository);
    
    public ProductServiceTest() {
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
     * Test of saveProduct method, of class ProductService.
     */
    @Test
    public void testSaveProduct() {
        System.out.println("saveProduct");
        
        Product product = new Product();
        product.setProductId((long) 1);
        product.setName("Kumis");
        product.setDescription("Mejor que el yogurt");

        Category category = new Category();
        category.setCategoryId((long) 1);
        category.setName("Lácteos");
        product.setCategoryId(category.getCategoryId());

        boolean saved = productService.saveProduct(product.getName(), product.getDescription(), category.getCategoryId());
        assertTrue(saved);
    }

    /**
     * Test of findAllProducts method, of class ProductService.
     */
    @Test
    public void testFindAllProducts() {
        System.out.println("findAllProducts");

        Category lacteos = new Category();
        lacteos.setCategoryId(1L);
        lacteos.setName("Lácteos");

        Product producto1 = new Product();
        producto1.setProductId(1L);
        producto1.setName("Yogurt");
        producto1.setDescription("De mora");
        producto1.setCategory(lacteos);

        Product producto2 = new Product();
        producto2.setProductId(2L);
        producto2.setName("Kumis");
        producto2.setDescription("Mejor que el yogurt");
        producto2.setCategory(lacteos);

        boolean saved3 = categoryService.saveCategory(lacteos.getName());
        productService = new ProductService(repository);
        assertTrue(saved3);
        boolean saved1 = productService.saveProduct(producto1.getName(), producto1.getDescription(), lacteos.getCategoryId());
        boolean saved2 = productService.saveProduct(producto2.getName(), producto2.getDescription(), lacteos.getCategoryId());
        assertTrue(saved1);
        assertTrue(saved2);

        List<Product> result = productService.findAllProducts();
        assertEquals(2, result.size());
    }

    /**
     * Test of findProductById method, of class ProductService.
     */
    @Test
    public void testFindProductById() {
        System.out.println("findProductById");
        Category category = new Category();
        Long i = 1L;
        category.setCategoryId(i);
        category.setName("Lácteos");
        
        boolean saved3 = categoryService.saveCategory(category.getName());
        assertTrue(saved3);
        Category c = categoryService.findCategoryById(i);
        assertNotNull(c);
        
        Product newProduct = new Product();
        newProduct.setName("Kumis");
        newProduct.setProductId(1L);
        newProduct.setDescription("Mejor que el yogurt");
        newProduct.setCategory(category);
        
        boolean saved = productService.saveProduct(newProduct.getName(), newProduct.getDescription(), category.getCategoryId());
        assertTrue(saved);
        Product p = productService.findProductById(1L);
        assertNotNull(p);
        assertEquals(newProduct.getProductId(), p.getProductId());
        System.out.println(""+ newProduct.getProductId()+":"+ p.getProductId());
    }

    /**
     * Test of findProductByCategory method, of class ProductService.
     */
    @Test
    public void testFindProductByCategory() {
        System.out.println("findProductByCategory");
        
        Category category = new Category();
        category.setCategoryId((long)1);
        category.setName("Lacteos");
        
        boolean saved = categoryService.saveCategory(category.getName());
        assertTrue(saved);
        Category c = categoryService.findCategoryById(category.getCategoryId());
        assertNotNull(c);

        Product product1 = new Product();
        product1.setProductId((long) 1);
        product1.setName("Kumis");
        product1.setDescription("Mejor que el yogurt");
        product1.setCategoryId(category.getCategoryId());
        
        boolean saved1 = productService.saveProduct(product1.getName(), product1.getDescription(), category.getCategoryId());
        assertTrue(saved1);
        Product p1 = productService.findProductById(product1.getProductId());
        assertNotNull(p1);
        assertEquals(product1.getProductId(), p1.getProductId());

        Product product2 = new Product();
        product2.setProductId((long) 2);
        product2.setName("Yogurt");
        product2.setDescription("De mora");
        product2.setCategoryId(category.getCategoryId());
        
        boolean saved2 = productService.saveProduct(product2.getName(), product2.getDescription(), category.getCategoryId());
        assertTrue(saved2);
        Product p2 = productService.findProductById(product2.getProductId());
        assertNotNull(p2);
        assertEquals(product2.getProductId(), p2.getProductId());

        Product product3 = new Product();
        product3.setProductId((long) 3);
        product3.setName("Leche");
        product3.setDescription("fresca");
        product3.setCategoryId(category.getCategoryId());

        boolean saved3 = productService.saveProduct(product3.getName(), product3.getDescription(), category.getCategoryId());
        assertTrue(saved3);
        Product p3 = productService.findProductById(product3.getProductId());
        assertNotNull(p3);
        assertEquals(product3.getProductId(), p3.getProductId()); 

        Product foundProducts = productService.findProductByCategory((long)1);

        assertNotNull(foundProducts);
    }

    /**
     * Test of findProductByName method, of class ProductService.
     */
    @Test
    public void testFindProductByName() {
        System.out.println("findProductByName");
        Category category1 = new Category();
        category1.setCategoryId(1L);
        category1.setName("Frutas");
        
        boolean saved = categoryService.saveCategory(category1.getName());
        assertTrue(saved);
        Category c = categoryService.findCategoryById(category1.getCategoryId());
        assertNotNull(c);

        Product product1 = new Product();
        product1.setProductId(1L);
        product1.setName("Kumis");
        product1.setDescription("Mejor que el yogurt");
        product1.setCategory(category1);
        
        boolean saved1 = productService.saveProduct(product1.getName(), product1.getDescription(), category1.getCategoryId());
        assertTrue(saved1);
        Product p1 = productService.findProductById(product1.getProductId());
        assertNotNull(p1);
        assertEquals(product1.getProductId(), p1.getProductId());

        Product foundProduct = productService.findProductByName("Kumis");

        assertNotNull(foundProduct);
        assertEquals(1, foundProduct.getProductId());

        assertEquals("Kumis", foundProduct.getName());
    }

    /**
     * Test of deleteProduct method, of class ProductService.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        
        Category category = new Category();
        category.setCategoryId(1L);
        category.setName("Lácteos");

        boolean saved1 = categoryService.saveCategory(category.getName());
        assertTrue(saved1);
        Category c = categoryService.findCategoryById(category.getCategoryId());
        assertNotNull(c);
        
        Product producto = new Product();
        producto.setProductId((long) 1);
        producto.setName("Kumis");
        producto.setDescription("Mejor que el yogurt");
        producto.setCategory(category);
        
        boolean saved2 = productService.saveProduct(producto.getName(), producto.getDescription(), category.getCategoryId());
        assertTrue(saved2);
        Product p = productService.findProductById(producto.getProductId());
        assertNotNull(p);
        assertEquals(producto.getProductId(), p.getProductId());

        Long productId = producto.getProductId();

        boolean deleted = productService.deleteProduct(productId);
        assertTrue(deleted);
        Product deletedProduct = productService.findProductById(productId);
        assertNull(deletedProduct);
    }

    /**
     * Test of editProduct method, of class ProductService.
     */
    @Test
    public void testEditProduct() {
        System.out.println("editProduct");
        
        Category category = new Category();
        category.setCategoryId((long)1);
        category.setName("Lácteos");
        
        boolean saved = categoryService.saveCategory(category.getName());
        assertTrue(saved);
        Category c = categoryService.findCategoryById(category.getCategoryId());
        assertNotNull(c);

        Product product1 = new Product();
        product1.setProductId((long) 1);
        product1.setName("Kumis");
        product1.setDescription("Mejor que el yogurt");
        product1.setCategory(category);
        
        boolean saved1 = productService.saveProduct(product1.getName(), product1.getDescription(), category.getCategoryId());
        assertTrue(saved1);
        Product p1 = productService.findProductById(product1.getProductId());
        assertNotNull(p1);
        assertEquals(product1.getProductId(), p1.getProductId());

        Product product2 = new Product();
        product2.setProductId(2L);
        product2.setName("Yogurt");
        product2.setDescription("De mora");
        product2.setCategory(category);
        
        boolean saved2 = productService.saveProduct(product2.getName(), product2.getDescription(), category.getCategoryId());
        assertTrue(saved2);
        Product p2 = productService.findProductById(product2.getProductId());
        assertNotNull(p2);
        assertEquals(product2.getProductId(), p2.getProductId());

        product1.setProductId((long)1);
        product1.setName("Leche");
        product1.setDescription("Fresca");
        product1.setCategoryId(category.getCategoryId());

        boolean edited = productService.editProduct(product1.getProductId(), product1);
        assertTrue(edited);
        
        Product foundProduct = productService.findProductByName("Leche");

        assertNotNull(foundProduct);
        
        System.out.println("Producto:\n"+foundProduct.getName());
    }
    
}
