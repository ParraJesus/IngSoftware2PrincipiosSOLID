package co.edu.unicauca.openmarket.access;

/**
 *
 * @author Jesus Parra
 */
public interface IRepository {
    
    void initDatabase(String sqlCommand);
    
    void connectDatabase();
    
    void disconnectDatabase();
}
