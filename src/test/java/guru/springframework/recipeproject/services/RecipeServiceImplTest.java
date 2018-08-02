package guru.springframework.recipeproject.services;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;
    RecipeServiceImpl recipeServiceImpl;

    @Before
    public void setUp() throws Exception {
        //Inicijalizacija Mock objekata
        MockitoAnnotations.initMocks(this);
        this.recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeServiceImpl.getRecipes()).thenReturn(recipeData);
        Set<Recipe> fetchedRecipes = recipeServiceImpl.getRecipes();
        assertEquals(fetchedRecipes.size(),1);

        //provjeri da li se repository metoda uistinu poziva samo jednom
        verify(recipeRepository, times(1)).findAll();

    }
}