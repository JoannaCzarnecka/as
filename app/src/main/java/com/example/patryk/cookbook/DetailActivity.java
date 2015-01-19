package com.example.patryk.cookbook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import com.example.patryk.cookbook.data.Recipe;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;


@EActivity (R.layout.activity_detail)
public class DetailActivity extends ActionBarActivity {

    @Extra
    Recipe recipe;

    @ViewById
    TextView title;

    @ViewById
    TextView introduction;

    @ViewById
    TextView ingredients;

    @ViewById
    TextView steps;

    @ViewById
    TextView created;

    @ViewById
    TextView preparationMinutes;

    @ViewById
    TextView cookingMinutes;

    @ViewById
    TextView servings;

    @AfterViews
    void init (){
        title.setText(recipe.title);
        introduction.setText(recipe.introduction);
        ingredients.setText(recipe.ingredients);
        steps.setText(recipe.steps);
        created.setText(recipe.created);
        preparationMinutes.setText(recipe.preparationMinutes);
        cookingMinutes.setText(recipe.cookingMinutes);
        servings.setText(recipe.servings);
    }


}
