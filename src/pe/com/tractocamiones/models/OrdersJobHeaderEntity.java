package pe.com.tractocamiones.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrdersJobHeaderEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public List<OrderJobHeader> getOrdersJobHeaderClient(int idClient){
        String sql="select * from order_job_header where id_cliente="+idClient;
        List<OrderJobHeader> ordersjobheader=new ArrayList<>();
        if(connection == null){
            return null;
        }
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                OrderJobHeader orderjobheader=new OrderJobHeader();
                orderjobheader.setId(rs.getInt("id"));
                orderjobheader.setDescription(rs.getString("description"));
                orderjobheader.setDescriptionService(rs.getString("description_service"));
                orderjobheader.setPrice(rs.getDouble("price"));
                orderjobheader.setIdState(rs.getString("id_state"));
                orderjobheader.setRegistrationDate(rs.getDate("registration_date"));
                ordersjobheader.add(orderjobheader);
            }
            return ordersjobheader;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OrderJobHeader> getOrdersJob(){
        String sql="select * from order_job_header";
        List<OrderJobHeader> ordersjobheader=new ArrayList<>();
        if(connection == null){
            return null;
        }
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                OrderJobHeader orderjobheader=new OrderJobHeader();
                orderjobheader.setId(rs.getInt("id"));
                orderjobheader.setDescription(rs.getString("description"));
                orderjobheader.setDescriptionService(rs.getString("description_service"));
                orderjobheader.setPrice(rs.getDouble("price"));
                orderjobheader.setIdState(rs.getString("id_state"));
                orderjobheader.setRegistrationDate(rs.getDate("registration_date"));
                ordersjobheader.add(orderjobheader);
            }
            return ordersjobheader;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
