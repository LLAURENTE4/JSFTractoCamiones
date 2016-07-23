package pe.com.tractocamiones.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class MachinesEntity {

    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public void setEditMachine(Machine machine){
        if(connection != null) {

            try {
                PreparedStatement pstm = null;
                pstm = getConnection().prepareStatement("update machine set mark= ?,model= ? ,manufacturing_year= ?,description= ?,plate_number=?  where id= ? ");
                pstm.setString(1, machine.getMark());
                pstm.setString(2, machine.getModel());
                pstm.setString(3, machine.getManufacturingYear());
                pstm.setString(4, machine.getDescription());
                pstm.setString(5, machine.getPlateNumber());
                pstm.setInt(6, machine.getId());
                pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   // public void setEditEmployee2(int id, String firstName,String lastName){
  //      int li_cant;
    //    String sql="update employees set first_name= ?,last_name= ? where employee_id= ? ";
//
  //      try {
    //        PreparedStatement pstm = connection.prepareStatement(sql);
      //      pstm.setString(1, firstName);
        //    pstm.setString(2, lastName);
          //  pstm.setInt(3, id);
            //li_cant=pstm.executeUpdate();
            //out.println("hola");
       // } catch (SQLException e) {
         //   e.printStackTrace();
        //}

//    }

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
