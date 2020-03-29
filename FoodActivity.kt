package edu.uc.willi6jd.mycaloriecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

/**
 * This will control the view when they get to the food page
 */
class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val btnCreate = findViewById(R.id.btnCreateFoodItem) as Button //Create food item button

        btnCreate.setOnClickListener {

            // Get input fields. Store them to food item variables
            var itemName = findViewById<TextView>(R.id.foodName); //Name of food item: input text field
            var itemCalories = findViewById<TextView>(R.id.foodCalories); //Calorie amount of food item: integer
            var itemSugar = findViewById<TextView>(R.id.foodSugar); //Sugar amount of food item: integer
            var itemProtein = findViewById<TextView>(R.id.foodProtein); //Protein amount of food: integer

            // Put food item variables into foodItem Object
            fun foodItem(nm: String, cal: Int, sgr: Int, pro: Int) {
                FoodItem.name = nm;
                FoodItem.calories = cal;
                FoodItem.sugar = sgr;
                FoodItem.protein = pro;
            }

            // Build FoodItem Array
            val foodItemArray = Array(20) { }

            // Push foodItem to FoodItem Array
            foodItemArray.add(foodItem(itemName, itemCalories, itemSugar, itemProtein))

            val lblFoodName: TextView = findViewById(R.id.lblFoodName) as TextView
            lblFoodName.setOnClickListener {
                lblFoodName.text = "Food Name: " + itemName.text;
            }
            val lblFoodCalories: TextView = findViewById(R.id.lblFoodCalories) as TextView
            lblFoodCalories.setOnClickListener {
                lblFoodCalories.text = "Calories: " + itemCalories.text
            }
            val lblFoodSugar: TextView = findViewById(R.id.lblFoodSugar) as TextView
            lblFoodSugar.setOnClickListener {
                lblFoodSugar.text = "Sugar: " + itemSugar.text
            }
            val lblFoodProtein: TextView = findViewById(R.id.lblFoodProtein) as TextView
            lblFoodProtein.setOnClickListener {
                lblFoodProtein.text = "Protein: " + itemProtein.text
            }
        }
    }

    object FoodItem {
        var name = "";
        var calories = 0;
        var sugar = 0;
        var protein = 0;
    }

}
