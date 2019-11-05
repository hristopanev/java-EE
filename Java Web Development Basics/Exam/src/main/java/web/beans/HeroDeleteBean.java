package web.beans;

import domain.models.service.HeroServiceModel;
import service.HeroService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class HeroDeleteBean extends BaseBean {

    HeroService heroService;

    public HeroDeleteBean() {
    }

    @Inject
    public HeroDeleteBean(HeroService heroService) {
        this.heroService = heroService;
    }

    public HeroServiceModel getHeroById(String id) {
        HeroServiceModel result = this.heroService.getById(id);

        return result;
    }

    public void delete() {
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");

        this.heroService.deleteHero(id);

        this.redirect("/home");
    }
}
