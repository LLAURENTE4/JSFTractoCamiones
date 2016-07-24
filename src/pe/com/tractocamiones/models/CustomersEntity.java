package pe.com.tractocamiones.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Frank on 23/07/2016.
 */
public class CustomersEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public Client getDataClient(String eMail,String password){
        String sql="select * from client where mail= '"+eMail+"' and password='"+password+"'";
        Client client=new Client();

        if(connection == null){
            return null;
        }
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                client.setId(rs.getInt("id"));
                client.setBussinessName(rs.getString("business_name"));
                client.setDocument(rs.getString("document"));
                client.setAddress(rs.getString("address"));
                client.setCellphone(rs.getString("cellphone"));
                client.setState(rs.getString("state"));
                client.setIdUser(rs.getString("id_user"));
                client.setMail(rs.getString("mail"));
                client.setPassword(rs.getString("password"));
                client.setRegistrationDate(rs.getDate("registration_date"));
            }
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
