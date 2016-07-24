package pe.com.tractocamiones.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.util.Date;

/**
 * Created by llaurente on 23/07/2016.
 */
public class ClientsEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public void addClient(String document, String bussinessName , String address , String cellphone, String state, String mail , String password){
        String sql="INSERT INTO client (document,bussines_name,address,cellphone,state,mail,password) VALUES (?,?,?,?,?,?,?)  ";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, document);
            pstm.setString(2, bussinessName);
            pstm.setString(3, address);
            pstm.setString(4, cellphone);
            pstm.setString(5, state);
            pstm.setString(6, mail);
            pstm.setString(7, password);

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
