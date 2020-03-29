package edu.uc.willi6jd.mycaloriecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * This will control the view when they get to hte recipe page
 */

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val btnCreate = findViewById(R.id.btnCreateRecipeItem) as Button //Create recipe button

        btnCreate.setOnClickListener {

            // Get input fields (by ID) store them to recipe item variables
            var itemName = findViewById<TextView>(R.id.recipeName); //Name of recipe: input text field
            var itemCount = findViewById<TextView>(R.id.recipeItemCount); //Number of food items in recipe: integer
            var itemDescription = findViewById<TextView>(R.id.recipeDescription); //Description of recipe: input text field, string

            // Put recipe item variables into recipeItem Object
            fun recipeItem(nm: String, cnt: Int, dsc: String) {
                RecipeItem.name = nm;
                RecipeItem.count = cnt;
                RecipeItem.Description = dsc;
            }

            // Build Recipe Array
            val recipeItemArray = Array(20) { }

            // Push recipeItem to Recipe Array
            recipeItemArray.add(recipeItem(itemName, itemCount, itemDescription))

            val lblRecipeName: TextView = findViewById(R.id.lblRecipeName) as TextView
            lblRecipeName.setOnClickListener {
                lblRecipeName.text = "Recipe Name: " + itemName.text;
            }
            val lblItemCount: TextView = findViewById(R.id.lblItemCount) as TextView
            lblItemCount.setOnClickListener {
                lblItemCount.text = "Item Count: " + itemCount.text
            }
            val lblItemDescription: TextView = findViewById(R.id.lblItemDescription) as TextView
            lblItemDescription.setOnClickListener {
                lblItemDescription.text = "Description: " + itemDescription.text
            }
        }
    }

    object RecipeItem {
        var name = "";
        var count = 0;
        var Description = "";
    }

}
