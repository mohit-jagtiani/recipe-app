package com.example.recipeapp.converters;



import com.example.recipeapp.commands.IngredientCommand;
import com.example.recipeapp.domain.Ingredient;
import com.example.recipeapp.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by jt on 6/21/17.
 */
public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final String UOM = "tsp";
    public static final Long ID_VALUE = 1L;


    IngredientToIngredientCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand();
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void testConvertNullUOM() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUnit(UOM);
        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);
        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(UOM, ingredientCommand.getUom());
    }

    @Test
    public void testConvertWithUom() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);


        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);
        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        // assertEquals(RECIPE, ingredientCommand.get);
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
       // assertEquals(UOM, ingredientCommand.getUom());
    }
}