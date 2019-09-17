package jobs.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named("logoutBean")
@RequestScoped
public class LogoutBean extends BaseBean {

    public void logout() throws IOException {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .invalidateSession();

        this.redirect("/");
    }
}
