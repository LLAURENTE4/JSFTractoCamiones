package pe.com.tractocamiones.models;

import java.sql.*;

/**
 * Created by Frank on 23/07/2016.
 */
public class CustomersEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public void addCurrency(String document, String bussinessName , String address , String cellphone, String state, String mail , String password){
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
        } }


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
