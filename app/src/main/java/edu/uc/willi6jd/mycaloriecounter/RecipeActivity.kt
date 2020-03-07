package edu.uc.willi6jd.mycaloriecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/**
 * This will control the view when they get to hte recipe page
 */

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val btnCreateRecipe = findViewById(R.id.btnCreateRecipeItem) as Button //Create recipe button

        btnCreateRecipe.setOnClickListener {

            // Get input fields (by ID) store them to recipe item variables
            var recipeName = findViewById<EditText>(R.id.recipeName); //Name of recipe: input text field
            var recipeCount = findViewById<EditText>(R.id.recipeItemCount); //Number of food items in recipe: integer
            var recipeDescription = findViewById<EditText>(R.id.recipeDescription); //Description of recipe: input text field, string

            // Put recipe item variables into recipeItem Object
            fun recipeItem(nm: String, cnt: Int, dsc: String) {
                RecipeItem.name = nm;
                RecipeItem.count = cnt;
                RecipeItem.Description = dsc;
            }

            // Build Recipe Array
            val recipeItemArray = Array(20) { }

            // Push recipeItem to Recipe Array
            recipeItemArray.add(recipeItem(nm, cnt, dsc))
        }
    }

    object RecipeItem {
        var name = "";
        var count = 0;
        var Description = "";
    }

}
