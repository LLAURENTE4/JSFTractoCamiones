package pe.com.tractocamiones.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "hrservicefacade", eager = true)
@SessionScoped

public class HRServiceFacade {

    private Connection connection;
    private Machine currentMachine;

    public HRServiceFacade() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() {
        return connection;
    }

    private MachinesEntity getMachinesEntity() {
        MachinesEntity machinesEntity = new MachinesEntity();
        machinesEntity.setConnection(connection);
        return machinesEntity;
    }

    public int getMachinesCount() {
        return getMachinesEntity().getMachines().size();
    }

    public List<Machine> getMachines() {
        return getMachinesEntity().getMachines();
    }

    public Machine getCurrentMachine() {
        return currentMachine;
    }

    public void addMachine(String description,String manufacturingYear,String mark , String model , String plateNumber){
        getMachinesEntity().addMachine(description,manufacturingYear,mark,model,plateNumber);

    }



}
