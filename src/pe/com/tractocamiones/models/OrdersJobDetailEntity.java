package pe.com.tractocamiones.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by llaurente on 29/07/2016.
 */

public class OrdersJobDetailEntity {


    private Connection connection;
    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}


    public void addOrdersJobDetail(List<OrderJobDetail> Detalle){

        for (OrderJobDetail det :Detalle){
            String sql="INSERT INTO order_job_detail (id,secuence,id_resource,quantity,price,id_user) VALUES (?,?,?,?,?,?)  ";

            try {
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setInt(1, det.getId());
                pstm.setInt(2, det.getSecuence());
                pstm.setInt(3, det.getIdResource());
                pstm.setDouble(4, det.getQuantity());
                pstm.setDouble(5, det.getPrice());
                pstm.setString(6, det.getIdUser());
               pstm.executeUpdate();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




}




