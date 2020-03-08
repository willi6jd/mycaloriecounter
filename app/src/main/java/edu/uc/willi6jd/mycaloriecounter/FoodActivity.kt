package edu.uc.willi6jd.mycaloriecounter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

/**
 * This will control the view when they get to the food page
 */
class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val listView = findViewById<ListView>(R.id.food_listview)
        listView.adapter = foodCustomerAdapter(this)

        val btnCreate = findViewById(R.id.btnCreateFoodItem) as Button //Create food item button

        btnCreate.setOnClickListener {

            // Get input fields. Store them to food item variables
            var itemName = findViewById<EditText>(R.id.foodName).toString(); //Name of food item: input text field
            var itemCalories = findViewById<EditText>(R.id.foodCalories).toInt(); //Calorie amount of food item: integer
            var itemSugar = findViewById<EditText>(R.id.foodSugar).toInt(); //Sugar amount of food item: integer
            var itemProtein = findViewById<EditText>(R.id.foodProtein).toInt(); //Protein amount of food: integer


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
        }
    }

/**
 * This custom adapter is used to fill the data in the list view
 */
private class foodCustomerAdapter(context: Context): BaseAdapter(){
        private val mContext: Context

        //Test values for filling JSON
        private val food = arrayListOf<String>("Peanut Butter", "Jelly", "Bread","Ham","Turkey")
        private val cal = arrayListOf<String>("80", "90", "200","350","999")
        private val fat = arrayListOf<String>("10", "2", "3","7","1")
        private val pro = arrayListOf<String>("15", "0", "0","12","19")

        init{
            mContext = context
        }
        //Rows in list
        override fun getCount(): Int {
            return food.size
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
            val rowMain = layoutInflater.inflate(R.layout.food_row, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.listFoodName)
            nameTextView.text = food.get(position)

            val calTextView = rowMain.findViewById<TextView>(R.id.listFoodCal)
            calTextView.text = cal.get(position)

            val fatTextView = rowMain.findViewById<TextView>(R.id.listFoodFat)
            fatTextView.text = fat.get(position)

            val proTextView = rowMain.findViewById<TextView>(R.id.listFoodPro)
            proTextView.text = pro.get(position)

            return rowMain
        }

    }
    object FoodItem {
        var name = "";
        var calories = 0;
        var sugar = 0;
        var protein = 0;
    }
}


