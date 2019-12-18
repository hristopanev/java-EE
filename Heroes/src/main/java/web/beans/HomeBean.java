package web.beans;

import domain.models.service.HeroServiceModel;
import service.HeroService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class HomeBean {

    private List<HeroServiceModel> heroServiceModel;

    private HeroService heroService;

    public HomeBean() {
    }

    @Inject
    public HomeBean(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostConstruct
    public void init() {
        setHeroServiceModel(this.heroService.getAllHeroes());
    }

    public List<HeroServiceModel> getHeroServiceModel() {
        return this.heroServiceModel;
    }

    public void setHeroServiceModel(List<HeroServiceModel> heroServiceModel) {
        this.heroServiceModel = heroServiceModel;
    }
}
