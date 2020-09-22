
package business;

import business.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class RegisterSessionBean implements RegisterSessionBeanLocal {

    @PersistenceContext(unitName = "ZavrsniRadPU")
    private EntityManager entityManager;

    @Override
    public boolean register(String first_name, String last_name, String username, String password) {

        Query query = entityManager.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        List<User> userList = query.getResultList();
        if (userList.isEmpty()) {
            User user = new User();
            user.setFirstName(first_name);
            user.setLastName(last_name);
            user.setUsername(username);
            user.setPassword(password);
            entityManager.persist(user);
            return true;
        } else {
            return false;
        }
    }
}
