package Utils;




import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author gar4a
 */
public class DataSource {
    private static DataSource instance;
    
    private Connection cnx;
    
    private final String URL = "jdbc:mysql://localhost:3306/books";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    
    DataSource() {
        try {
       cnx = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to books !");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if (instance==null)
            instance = new DataSource();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
}
