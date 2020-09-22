package business;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


@Local
public interface RegisterSessionBeanLocal {
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean register(String first_name, String last_name, String username, String password);
}
