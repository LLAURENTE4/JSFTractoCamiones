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


    private UsersEntity getUsersEntity() {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setConnection(connection);
        return usersEntity;
    }
    private ClientsEntity getClientsEntity() {
        ClientsEntity clientsEntity = new ClientsEntity();
        clientsEntity.setConnection(connection);
        return clientsEntity;
    }


    public int getMachinesCount() {
        return getMachinesEntity().getMachines().size();
    }

    public List<Machine> getMachines() {
        return getMachinesEntity().getMachines();
    }

    public void addMachine(String description,String manufacturingYear,String mark , String model , String plateNumber){
        getMachinesEntity().addMachine(description,manufacturingYear,mark,model,plateNumber);

    }

    public void addUser(String id,String lastName,String firstName , String state , String document,String password){
        getUsersEntity().addUser(id,lastName,firstName,state,document,password);

    }


    public void addClient(String document, String bussinessName , String address , String cellphone, String state, String mail , String password){
        getClientsEntity().addClient(document,bussinessName,address,cellphone,state,mail,password);


    }







}
