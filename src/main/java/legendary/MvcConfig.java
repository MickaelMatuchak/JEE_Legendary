package legendary;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/accueil").setViewName("accueil");
        registry.addViewController("/personnages").setViewName("personnages");
        registry.addViewController("/personnages/{id}").setViewName("personnage-details");
        registry.addViewController("/personnages/add").setViewName("addPersonnage");
        registry.addViewController("/items").setViewName("items");
        registry.addViewController("/items/{id}").setViewName("item-details");
        registry.addViewController("/items/add").setViewName("addItem");
        registry.addViewController("/login").setViewName("login");
    }

}