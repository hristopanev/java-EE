package web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("logoutBean")
@RequestScoped
public class UserLogoutBean extends BaseBean {
    public UserLogoutBean() {
    }

    public void logout() {
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .invalidateSession();
        this.redirect("/index");
    }
}
