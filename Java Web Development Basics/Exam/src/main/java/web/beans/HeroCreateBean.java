package web.beans;

import domain.models.binding.HeroCreateBindingModel;
import domain.models.service.HeroServiceModel;
import org.modelmapper.ModelMapper;
import service.HeroService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroCreateBean extends BaseBean {

    private HeroCreateBindingModel heroCreateBindingModel;

    private ModelMapper modelMapper;
    private HeroService heroService;

    public HeroCreateBean() {
    }

    @Inject
    public HeroCreateBean(ModelMapper modelMapper, HeroService heroService) {
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }

    @PostConstruct
    public void init() {
        this.heroCreateBindingModel = new HeroCreateBindingModel();
    }

    public HeroCreateBindingModel getHeroCreateBindingModel() {
        return this.heroCreateBindingModel;
    }

    public void setHeroCreateBindingModel(HeroCreateBindingModel heroCreateBindingModel) {
        this.heroCreateBindingModel = heroCreateBindingModel;
    }

    public void createHero() {
        HeroServiceModel heroServiceModel = this.modelMapper.map(
                heroCreateBindingModel, HeroServiceModel.class
        );
        this.heroService.createHero(heroServiceModel);

        this.redirect("/home");
    }
}
