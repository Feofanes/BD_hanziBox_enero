
package bd_hanzibox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private Conexion(){}    // constructor
    
    // En esta clase haremos los metodos de abrir y cerrar conexion
    
    // variable static porque pertenecera a toda la clase
    private static Connection conexion;
    
    private static Conexion instancia; 
    
    // creamos variables para poder conectarnos a la BD
    private static final String URL = "jdbc:mysql://localhost/BD_hanziBox";   // guardara la direccion de la BD
    
    private static final String username = "root";
    
    private static final String password = "";
    
    
    public Connection conectar(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Configurar la cadena de conexión con la codificación UTF-8. PROPUESTA DE CHAT PARA EVITAR DRAMAS CON LOS HANZI
            String url = "jdbc:mysql://localhost/BD_hanziBox?useUnicode=true&characterEncoding=UTF-8";
            conexion = DriverManager.getConnection(url, username, password);


            //conexion = DriverManager.getConnection(URL, username, password);    // obtenemos la conexion
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        
        return conexion;
    }   // metodo para conectarnos a la BD
    
    public void desconectar() throws SQLException{
        
        try{
            
            conexion.close();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error : " + e);
            conexion.close();
            
        }finally{
            
            conexion.close();
            
        }
        
    }   // metodo para cerrar la BD

    public static Conexion getInstance(){
        
        if(instancia == null){
            
            instancia = new Conexion();
             
        }   // si la instancia es nula crea una nueva!
        
        return instancia;
        
    }   // patron Singleton !

    public PreparedStatement prepareStatement(String select__from_hanzi_entrada_WHERE__LIKE_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
