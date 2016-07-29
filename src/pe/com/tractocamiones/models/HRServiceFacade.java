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
    private Client currentClient;
    private User currentUser;
    private String loginClientError;
    private String loginUserError;

    public HRServiceFacade() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource_tractocamiones");
            connection = ds.getConnection();
            currentClient=new Client();
            currentUser=new User();
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
    
    public List<OrderJobHeader> getOrderJob() {
        return getOrdersJobHeaderEntity().getOrdersJob();
    }

    public Client getCurrentClient(){return currentClient;}
    public void setCurrentClient(Client currentClient){this.currentClient = currentClient;}
    public String loginClient(){
        this.currentClient=getCustomersEntity().getDataClient(currentClient.getMail(), currentClient.getPassword());
        if("".equals(currentClient.getBussinessName()) || currentClient.getBussinessName()==null){
            this.loginClientError="Incorrect data";
            return "loginClient";
        }else{
            this.loginClientError="";
            return "ordersClient";
        }
    }

    public User getCurrentUser(){return currentUser;}
    public void setCurrentUser(User currentUser){this.currentUser = currentUser;}
    public String loginUser(){
        this.currentUser=getUsersEntity().getDataUser(currentUser.getId(),currentUser.getPassword());
        if("".equals(currentUser.getLastName()) || currentUser.getLastName()==null){
            this.loginUserError="Incorrect data";
            return "loginUser";
        }else{
            this.loginUserError="";
            return "userMain";
        }
    }

    public int getMachinesCount(){return getMachinesEntity().getMachines().size();}

    public List<Machine> getMachines(){return getMachinesEntity().getMachines();}

    public void addMachine(String description,String manufacturingYear,String mark , String model , String plateNumber){
        getMachinesEntity().addMachine(description,manufacturingYear,mark,model,plateNumber);
    }

    public void addClient(String document, String bussinessName , String address , String cellphone, String state, String mail , String password){
        getCustomersEntity().addClient(document,bussinessName,address,cellphone,state,mail,password);
    }

    public void addUser(String id,String lastName,String firstName , String state , String document,String password){
        getUsersEntity().addUser(id,lastName,firstName,state,document,password);
    }

    public String getLoginClientError() {
        return loginClientError;
    }

    public void setLoginClientError(String loginClientError) {
        this.loginClientError = loginClientError;
    }

    public String getLoginUserError() {
        return loginUserError;
    }

    public void setLoginUserError(String loginUserError) {
        this.loginUserError = loginUserError;
    }

}
