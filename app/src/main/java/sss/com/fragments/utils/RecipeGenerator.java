package sss.com.fragments.utils;

import java.util.ArrayList;
import java.util.List;

import sss.com.fragments.models.RecipeModel;

public class RecipeGenerator {
    public static List<RecipeModel> generateRecipes(){
        ArrayList<RecipeModel> tmp = new ArrayList<>();
        for (int i = 0; i< 10; i++) tmp.add(new RecipeModel("Title " + i, "Description " + i));
        return tmp;
    }
}
