package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/recipes")
    public String getRecipes(Model model) {
        log.debug("Getting recipes..");
        model.addAttribute("recipes", recipeService.getRecipes());
        log.debug("Recipes fetched...");
        return "index";
    }
}
