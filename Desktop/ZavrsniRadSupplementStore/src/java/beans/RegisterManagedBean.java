package beans;

import business.RegisterSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "registerManagedBean", eager = true)
@SessionScoped
public class RegisterManagedBean implements Serializable{

    @EJB
    private RegisterSessionBeanLocal registerSessionBeanLocal;

    private String message = "";
    private String first_name;
    private String last_name;
    private String username;
    private String password;

    public RegisterManagedBean() {
    }

    public String register() {

        boolean userCreated = registerSessionBeanLocal.register(first_name, last_name, username, password);
        if (userCreated) {
            return "index";
        }
        message = "Unijeto korisničko ime je zauzeto";
        return "register";
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public RegisterSessionBeanLocal getRegisterSessionBeanLocal() {
        return registerSessionBeanLocal;
    }

    public void setRegisterSessionBeanLocal(RegisterSessionBeanLocal registerSessionBeanLocal) {
        this.registerSessionBeanLocal = registerSessionBeanLocal;
    }

  
    



}


