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
    private OrderJobHeader currentOrderJobHeader;
    private String loginClientError;
    private String loginUserError;
    private String pageUserMain="ordersFull.xhtml";
    private String pageClientMain="ordersClient.xhtml";

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
    private StatesEntity getStatesEntity() {
        StatesEntity statesEntity = new StatesEntity();
        statesEntity.setConnection(connection);
        return statesEntity;
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

    /*Current Client*/
    public Client getCurrentClient(){return currentClient;}
    public void setCurrentClient(Client currentClient){this.currentClient = currentClient;}
    public String loginClient(){
        this.currentClient=getCustomersEntity().getDataClient(currentClient.getMail(), currentClient.getPassword());
        if("".equals(currentClient.getBussinessName()) || currentClient.getBussinessName()==null){
            this.loginClientError="Incorrect data";
            return "loginClient";
        }else{
            this.loginClientError="";
            return "clientMain";
        }
    }

    /*Current User*/
    public User getCurrentUser(){return currentUser;}
    public void setCurrentUser(User currentUser){this.currentUser = currentUser;}
    public String loginUser(){
        this.currentUser=getUsersEntity().getDataUser(currentUser.getId(),currentUser.getPassword());
        if("".equals(currentUser.getId()) || currentUser.getId()==null){
            this.loginUserError="Incorrect data";
            return "loginUser";
        }else{
            this.loginUserError="";
            return "userMain";
        }
    }

    public int getMachinesCount(){return getMachinesEntity().getMachines().size();}

    public List<Machine> getMachines(){return getMachinesEntity().getMachines();}

    public List<State> getStates(){return getStatesEntity().getStates();}

    public void addMachine(){
        getMachinesEntity().addMachine(currentMachine.getDescription(),currentMachine.getManufacturingYear(),currentMachine.getMark(),currentMachine.getModel(),currentMachine.getPlateNumber());
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


    public String getPageUserMain() {
        return pageUserMain;
    }

    public void setPageUserMain(String pageUserMain) {
        this.pageUserMain = pageUserMain;
    }

    public String getPageClientMain() {
        return pageClientMain;
    }

    public void setPageClientMain(String pageClientMain) {
        this.pageClientMain = pageClientMain;
    }

    public Machine getCurrentMachine() {
        return currentMachine;
    }

    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
    }

    public OrderJobHeader getCurrentOrderJobHeader() {
        return currentOrderJobHeader;
    }

    public void setCurrentOrderJobHeader(OrderJobHeader currentOrderJobHeader) {
        this.currentOrderJobHeader = currentOrderJobHeader;
    }
}
