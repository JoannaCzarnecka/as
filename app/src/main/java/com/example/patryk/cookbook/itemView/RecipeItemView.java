package com.example.patryk.cookbook.itemView;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.patryk.cookbook.R;
import com.example.patryk.cookbook.data.Recipe;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.list_item)
public class RecipeItemView extends RelativeLayout {

    @ViewById
    TextView title;

    @ViewById
    TextView introduction;

    @ViewById
    TextView acronym;

    public RecipeItemView(Context context) {
        super(context);
    }

    public void bind(Recipe recipe) {
        title.setText(recipe.title);
        introduction.setText(recipe.introduction);
        acronym.setText(recipe.title.substring(0,1));
    }
}

