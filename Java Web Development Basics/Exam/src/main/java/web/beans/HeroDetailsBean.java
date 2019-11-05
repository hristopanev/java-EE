package web.beans;

import domain.models.service.HeroServiceModel;
import service.HeroService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroDetailsBean {

    private HeroServiceModel heroServiceModel;

    private HeroService heroService;

    public HeroDetailsBean() {
    }

    @Inject
    public HeroDetailsBean(HeroService heroService) {
        this.heroService = heroService;
    }

    public HeroServiceModel getHero(String id) {
        return this.heroService.getById(id);
    }

    public HeroServiceModel getHeroServiceModel() {
        return this.heroServiceModel;
    }

    public void setHeroServiceModel(HeroServiceModel heroServiceModel) {
        this.heroServiceModel = heroServiceModel;
    }
}
