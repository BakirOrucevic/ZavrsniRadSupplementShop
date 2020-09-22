package beans;

import business.LoginSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginManagedBean", eager = true)
@SessionScoped
public class LoginManagedBean implements Serializable {

    @EJB
    private LoginSessionBeanLocal loginSessionBeanLocal;
    private String username;
    private String password;

    public LoginManagedBean() {
    }

    public String login() {
        boolean userLogged = loginSessionBeanLocal.login(username, password);
      

        if (userLogged) {
        
            return "index";
        }
        return "register";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
