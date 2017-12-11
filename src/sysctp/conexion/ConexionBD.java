

package sysctp.conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * realiza la conexion a la base de datos permitiendo realizar consultas o modificaciones
 * @author jarteaga
 */
public class ConexionBD
{

    /**
     * Variable que define el tipo de base de datos a conectar
     */
    private  Connection conexion;

    private  Statement estatuto;

    /**
     * Nombre del usuario de la base de datos
     */
    private  String nombreUsuario= "postgres";

    /**
     * Contrasena de la base de datos
     */
    private  String contrasena="postgres";

    private String nombreBaseDatos="SistemaTiquetesPrepagos";

    /** 
     * Metodo encargado de efectuar la conexion
     */
    public  void conectar()
    {

        String nombreDriver = null;
        String url = null;

        nombreDriver = "org.postgresql.Driver";//Driver PostgresSQL
        url =  "jdbc:postgresql://192.168.1.28:5432/"+nombreBaseDatos;
        //url =  "jdbc:postgresql://192.168.1.128:5432/"+nombreBaseDatos;
       // url =  "jdbc:postgresql://192.168.1.249:5432/"+nombreBaseDatos;
        try
        {
            Class.forName(nombreDriver).newInstance();
            conexion = DriverManager.getConnection(url,nombreUsuario,contrasena);
            estatuto = conexion.createStatement();

        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    /**
     * Metodo encargado de cerrar la conexion
     */
    public  void desconectar()
    {
        try
        {
            estatuto.close();
            conexion.close();
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para ejecutar consultas de tipo INSERT, UPDATE, DELETE
     * @param querySQL String consulta en SQL
     */
    public  void executeUpdateQuery(String querySQL)
    {
        try
        {
            conectar();
            estatuto.executeUpdate(querySQL);
            //desconectar();
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para ejecutar consultas de tipo SELECT
     * @param querySQL String consulta en SQL
     * @return ResultSet con los valores encontrados
     */
    public  ResultSet executeQuery(String querySQL)
    {
        try
        {
            conectar();
            return estatuto.executeQuery(querySQL);
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}



