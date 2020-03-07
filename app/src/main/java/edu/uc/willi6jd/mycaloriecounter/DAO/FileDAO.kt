package edu.uc.willi6jd.mycaloriecounter.DAO

import retrofit2.Call
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.uc.willi6jd.mycaloriecounter.DTO.Food
import edu.uc.willi6jd.mycaloriecounter.FoodActivity
import java.io.IOException

/**
 * This will read data from the storage file and write data to it. will deliver the data to the service
 */
interface FileDAO {
    /**
     * These may be parameters
     * context: Context, fileName: String
     */
    fun getJsonDataFromAsset(context: Context):ArrayList<Food> {
        val jsonString: String
        try {
            jsonString = context.assets.open("food.JSON").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            var food = ArrayList<Food>()
            return food
        }
        val gson = Gson()
        val listFromGson: ArrayList<Food> = gson.fromJson(
            jsonString,
            object : TypeToken<ArrayList<Any?>?>() {}.type
        )
        return listFromGson
    }
}