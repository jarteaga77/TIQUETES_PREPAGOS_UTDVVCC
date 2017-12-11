
package sysctp.dominio.arqueo.categoria;

import sysctp.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class Dao_Arqueo_Categoria 
{
   private ConexionBD conexion=new ConexionBD();
   
   
   public void registroArqueoCategoria(Arqueo_Categoria arqueo)
   {
      conexion.executeUpdateQuery("INSERT INTO controles_arqueos.arqueo_categoria (id_usuario,total_venta,fecha_inicial,fecha_final,fecha_realizacion)VALUES("+arqueo.getId_usuario()+","+arqueo.getTotal_venta()+", '"+arqueo.getFechaIni()+"', '"+arqueo.getFechaFin()+"', '"+arqueo.getFecha_arqueo()+"')");
      conexion.desconectar();
 
   }
   
   public void registroArqueoCategoriaDepe(Arqueo_Categoria arqueo)
   {
      conexion.executeUpdateQuery("INSERT INTO controles_arqueos.arqueo_categoria_dependencia (id_usuario,total_venta,fecha_inicial,fecha_final,fecha_realizacion)VALUES("+arqueo.getId_usuario()+","+arqueo.getTotal_venta()+", '"+arqueo.getFechaIni()+"', '"+arqueo.getFechaFin()+"', '"+arqueo.getFecha_arqueo()+"')");
      conexion.desconectar();
   }
   
   public void registoArqVenCatDepe(Arqueo_Categoria arqueo)
   {
       conexion.executeUpdateQuery("INSERT INTO controles_arqueos.arq_ven_dep_cat (arq_fecha_ini,arq_fecha_fin,arq_fecha_gene,id_usuario)VALUES('"+arqueo.getFechaIni()+"', '"+arqueo.getFechaFin()+"', '"+arqueo.getFecha_arqueo()+"', "+arqueo.getId_usuario()+" )");
       conexion.desconectar();
   }
   
}
