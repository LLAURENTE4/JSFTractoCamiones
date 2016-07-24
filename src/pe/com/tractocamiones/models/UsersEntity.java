package pe.com.tractocamiones.models;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public void addUser(String id,String lastName,String firstName , String state , String document,String password){
        String sql="INSERT INTO user (id,last_name,first_name,state,document,password) VALUES (?,?,?,?,?,?)  ";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, lastName);
            pstm.setString(3, firstName);
            pstm.setString(4, state);
            pstm.setString(5, document);
            pstm.setString(6, password);

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User getDataUser(String id,String password){
        String sql="select * from user where id= '"+id+"' and password='"+password+"'";

        User user=new User();

        if(connection == null){
            return null;
        }

        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                user.setId(rs.getString("id"));
                user.setLastName(rs.getString("last_name"));
                user.setFirstName(rs.getString("first_name"));
                user.setState(rs.getString("state"));
                user.setDocument(rs.getString("document"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
