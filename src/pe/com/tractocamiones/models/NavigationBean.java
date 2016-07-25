package pe.com.tractocamiones.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;

@Named
@SessionScoped

public class NavigationBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String page="ordersFull.xhtml";

    public String getPage() {
        return page;
    }

    public void setPage(String currentPage) {
        this.page=currentPage;
    }
}