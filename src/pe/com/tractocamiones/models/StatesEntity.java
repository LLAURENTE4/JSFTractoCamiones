package pe.com.tractocamiones.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 29/07/2016.
 */
public class StatesEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public List<State> getStates(){

        String sql="SELECT * FROM state";

        List<State> states=new ArrayList<>();
        if(connection == null){
            return null;
        }
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                State state=new State();

                state.setId(rs.getString("id"));
                state.setDescription(rs.getString("description"));

                states.add(state);
            }
            return states;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
