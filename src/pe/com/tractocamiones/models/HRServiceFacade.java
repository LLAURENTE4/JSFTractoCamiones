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
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource_tractocamiones");
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
    private CustomersEntity getCustomersEntity() {
        CustomersEntity customersEntity = new CustomersEntity();
        customersEntity.setConnection(connection);
        return customersEntity;
    }
    private OrdersJobHeaderEntity getOrdersJobHeaderEntity() {
        OrdersJobHeaderEntity ordersjobheaderEntity = new OrdersJobHeaderEntity();
        ordersjobheaderEntity.setConnection(connection);
        return ordersjobheaderEntity;
    }

    public List<OrderJobHeader> getOrderJobHeaderClient(int idClient) {
        return getOrdersJobHeaderEntity().getOrdersJobHeaderClient(idClient);
    }
    public Client getDataClient(String email,String password){
        return getCustomersEntity().getDataClient(email,password);
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

    public void setCurrentEmployee(Machine currentMachine) {
        this.currentMachine = currentMachine;
    }





}
