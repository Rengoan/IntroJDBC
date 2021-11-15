
import java.sql.*;


public class TestMySQL {

    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/test_java?useSSL=FALSE&"+
                "useTimezone=TRUE&serverTimezone=UTC&"+
                "allowPublicKeyRetrieval=TRUE"; //Para conectar a la base de datos
        
        try{
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //1. Establecemos nuestra conexion a la BD
            Connection conexion = DriverManager.getConnection(url, "root", "");
            
            //2. Creamos el statement para poder ejecutar nuestras consultas
            Statement instruccion = conexion.createStatement();
            
            //3. Definimos nuestra consulta
            var sql = "SELECT idpersona, nombre, apellido, email, telefono "+ "FROM test_java.persona";
            
            //4. Ejecutamos la consulta
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                //Imprimir el contenido de cada una de las personas
                System.out.print("Id. persona: "+ resultado.getInt("idpersona"));
                System.out.print(" Nombre: "+ resultado.getString("nombre"));
                System.out.print(" Apellidos: "+ resultado.getString("apellido"));
                System.out.print(" Email: "+ resultado.getString("email"));
                System.out.print(" Telefono: "+ resultado.getString("telefono"));
                System.out.println("");
            }
            //Se cierra en este orden, ResultSet, Statement y conexion
            resultado.close();
            instruccion.close();
            conexion.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
