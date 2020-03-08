package edu.uc.willi6jd.mycaloriecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/**
 * This will control the view when they get to hte recipe page
 */

class RecipeActivity : AppCompatActivity() {

    object RecipeItem {
        var name = "";
        var count = 0;
        var Description = "";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val btnCreate = findViewById(R.id.btnCreateRecipeItem) as Button //Create recipe button

        btnCreate.setOnClickListener {

            // Get input fields (by ID) store them to recipe item variables
            var itemName = findViewById<EditText>(R.id.recipeName).toString(); //Name of recipe: input text field
            var itemCount = findViewById<EditText>(R.id.recipeItemCount).toInt(); //Number of food items in recipe: integer
            var itemDescription = findViewById<EditText>(R.id.recipeDescription).toString(); //Description of recipe: input text field, string

            // Put recipe item variables into recipeItem Object
            fun recipeItem(name: String, count: Int, description: String) {
                RecipeItem.name = name;
                RecipeItem.count = count;
                RecipeItem.Description = description;
            }

            // Build Recipe Array
            val recipeItemArray = Array(20) { }

            // Push recipeItem to Recipe Array
            recipeItemArray.add(recipeItem(itemName, itemCount, itemDescription))
        }
    }
}
