package pe.com.tractocamiones.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class MachinesEntity {

    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public void setEditMachine(int id, String description,String manufacturingYear,String mark , String model , String plateNumber){
       int li_cant;
       String sql="update machine set mark= ?,model= ? ,manufacturing_year= ?,description= ?,plate_number=?  where id= ? ";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, mark);
            pstm.setString(2, model);
            pstm.setString(3, manufacturingYear);
            pstm.setString(4, description);
            pstm.setString(5, plateNumber);
            pstm.setInt(6, id);

            li_cant=pstm.executeUpdate();
            out.println("hola");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addMachine(String description,String manufacturingYear,String mark , String model , String plateNumber){
               String sql="INSERT INTO machine (mark,model,manufacturing_year,description,plate_number) VALUES (?,?,?,?,?)  ";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, mark);
            pstm.setString(2, model);
            pstm.setString(3, manufacturingYear);
            pstm.setString(4, description);
            pstm.setString(5, plateNumber);


            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Machine> getMachines(){

        String sql="SELECT * FROM machine";

        List<Machine> machines=new ArrayList<>();
        if(connection == null){
            return null;
        }
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                Machine machine=new Machine();

                machine.setId(rs.getInt("id"));
                machine.setMark(rs.getString("mark"));
                machine.setModel(rs.getString("model"));
                machine.setManufacturingYear(rs.getString("manufacturing_year"));
                machine.setDescription(rs.getString("description"));
                machine.setPlateNumber(rs.getString("plate_number"));

                machines.add(machine);
            }
            return machines;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
