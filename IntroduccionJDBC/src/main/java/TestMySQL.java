
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestMySQL {

    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:mysql//localhost:3306/test_java?useSSL=false"+
                "useTimezone=true&serverTimezone=UTC&"+
                "allowPublicKeyRetrieval=true"; //Para conectar a la base de datos
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace(System.out);
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
