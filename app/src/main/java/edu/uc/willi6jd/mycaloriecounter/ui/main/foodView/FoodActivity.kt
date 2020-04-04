package edu.uc.willi6jd.mycaloriecounter.ui.main.foodView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import edu.uc.willi6jd.mycaloriecounter.DTO.foodModel.Food
import edu.uc.willi6jd.mycaloriecounter.R


/**
 * This will control the view when they get to the food page
 */
class FoodActivity : AppCompatActivity() {
    //var foodList = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val listView = findViewById<ListView>(R.id.food_listview)
        listView.adapter =
            FoodCustomerAdapter(
                this
            )
//
//        val btnCreate = findViewById(R.id.btnCreateFoodItem) as Button //Create food item button
//
//        btnCreate.setOnClickListener {
//
//            // Get input fields. Store them to food item variables
//            var itemName = findViewById<EditText>(R.id.foodName); //Name of food item: input text field
//            var itemCalories = findViewById<EditText>(R.id.foodCalories); //Calorie amount of food item: integer
//            var itemSugar = findViewById<EditText>(R.id.foodSugar); //Sugar amount of food item: integer
//            var itemProtein = findViewById<EditText>(R.id.foodProtein); //Protein amount of food: integer
//
//            // Put food item variables into foodItem Object
//            fun foodItem(nm: String, cal: Int, sgr: Int, pro: Int) {
//                FoodItem.name = nm;
//                FoodItem.calories = cal;
//                FoodItem.sugar = sgr;
//                FoodItem.protein = pro;
//            }
//
//            // Build FoodItem Array
//            val foodItemArray = Array(20) { }
//
//            // Push foodItem to FoodItem Array
//            foodItemArray.add(foodItem(nm, cal, sgr, pro))
//        }
    }

/**
 * This custom adapter is used to fill the data in the list view
 */
private class FoodCustomerAdapter(context: Context): BaseAdapter(){
        private val mContext: Context = context

    //Test values for filling JSON
        private val food = arrayListOf("Peanut Butter", "Jelly", "Bread","Ham","Turkey")
        private val cal = arrayListOf("80", "90", "200","350","999")
        private val fat = arrayListOf("10", "2", "3","7","1")
        private val pro = arrayListOf("15", "0", "0","12","19")

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
            var currentItem = "Name: " + food[position]
            nameTextView.text = currentItem

            val calTextView = rowMain.findViewById<TextView>(R.id.listFoodCal)
            var currentCal = "Calories: " + cal[position]
            calTextView.text = currentCal

            val fatTextView = rowMain.findViewById<TextView>(R.id.listFoodFat)
            var currentFat = "Fat: " + fat[position]
            fatTextView.text = currentFat

            val proTextView = rowMain.findViewById<TextView>(R.id.listFoodPro)
            var currentPro = "Pro: " + pro[position]
            proTextView.text = currentPro

            return rowMain
        }

    }
    object FoodItem {
        var name = ""
        var calories = 0
        var sugar = 0
        var protein = 0
    }
}


