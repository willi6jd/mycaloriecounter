package edu.uc.willi6jd.mycaloriecounter.ui.main.recipeView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import edu.uc.willi6jd.mycaloriecounter.R

/**
 * This will control the view when they get to hte recipe page
 */
class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val listView = findViewById<ListView>(R.id.recipe_listview)
        listView.adapter =
            RecipeCustomerAdapter(
                this
            )
//        val btnCreate = findViewById(R.id.btnCreateRecipeItem) as Button //Create recipe button
//
//        btnCreate.setOnClickListener {
//
//            // Get input fields (by ID) store them to recipe item variables
//            var itemName = findViewById<EditText>(R.id.recipeName); //Name of recipe: input text field
//            var itemCount = findViewById<EditText>(R.id.recipeItemCount); //Number of food items in recipe: integer
//            var itemDescription = findViewById<EditText>(R.id.recipeDescription); //Description of recipe: input text field, string
//
//            // Put recipe item variables into recipeItem Object
//            fun recipeItem(nm: String, cnt: Int, dsc: String) {
//                RecipeItem.name = nm;
//                RecipeItem.count = cnt;
//                RecipeItem.Description = dsc;
//            }
//
//            // Build Recipe Array
//            val recipeItemArray = Array(20) { }
//
//            // Push recipeItem to Recipe Array
//            recipeItemArray.add(recipeItem(nm, cnt, dsc))
//        }
    }

    /**
     * This is created in order to fill the listview with the recipes. This may change once we integrate file reading and writing.
     */
    private class RecipeCustomerAdapter(context: Context): BaseAdapter(){
        private val mContext: Context = context

        //Test values for filling JSON
        private val recipe = arrayListOf("Spaghetti", "Ham Sandhich","Fried Chicken, French Fries, Toast and Sauce")
        private val count = arrayListOf("5", "3", "4","350","999")
        private val description = arrayListOf("Noodles and meatsauce with cheese and garlic bread", "Bread, ham and cheese","Fried Chicken with french fries, buttered toast and sauce")

        //Rows in list
        override fun getCount(): Int {
            return recipe.size
        }

        //Select item
        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        //get selected item's id
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //Displays each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
//            val textView = TextView(mContext)
//            textView.text = "HERE"
//            return textView
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.recipe_row, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.listRecipeName)
            var currentItem = "Name: " + recipe[position]
            nameTextView.text = currentItem

            val calTextView = rowMain.findViewById<TextView>(R.id.listRecipeCount)
            var currentCount = "Count: " + count[position]
            calTextView.text = currentCount

            val fatTextView = rowMain.findViewById<TextView>(R.id.listRecipeDescription)
            var currentDescription = "Description: " + description[position]
            fatTextView.text = currentDescription

            return rowMain
        }

    }

    object RecipeItem {
        var name = ""
        var count = 0
        var Description = ""
    }

}
