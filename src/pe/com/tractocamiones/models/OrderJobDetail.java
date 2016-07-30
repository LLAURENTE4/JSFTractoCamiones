package pe.com.tractocamiones.models;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by llaurente on 29/07/2016.
 */

@ManagedBean(name = "orderjobdetail")
@SessionScoped
public class OrderJobDetail {
    private Integer id;
    private Integer secuence;
    private Integer idResource;
    private Double quantity;
    private Double price;
    private String idUser;
    private Date registrationDate;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSecuence() {
        return secuence;
    }

    public void setSecuence(Integer secuence) {
        this.secuence = secuence;
    }

    public Integer getIdResource() {
        return idResource;
    }

    public void setIdResource(Integer idResource) {
        this.idResource = idResource;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }





}
