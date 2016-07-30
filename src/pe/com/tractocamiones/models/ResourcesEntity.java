package pe.com.tractocamiones.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by llaurente on 29/07/2016.
 */
public class ResourcesEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public List<Resource> getResource(){

        String sql="SELECT * FROM resource";

        List<Resource> resources=new ArrayList<>();
        if(connection == null){
            return null;
        }
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                Resource resource=new Resource();

                resource.setId(rs.getInt("id"));
                resource.setName(rs.getString("resourcename"));
                resource.setUnit(rs.getString("unit"));
                resource.setPriceSale(rs.getDouble("price_sale"));

                resources.add(resource);
            }
            return resources;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
