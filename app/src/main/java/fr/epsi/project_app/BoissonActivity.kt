package fr.epsi.project_app

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.epsig2.fr.epsi.project_app.Product
import fr.epsi.epsig2.fr.epsi.project_app.ProductAdapter
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.util.*

class BoissonActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boisson)
        showBtnBack()
        setHeaderTitle(getString(R.string.txt_boissons))
        val products = arrayListOf<Product>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProduct)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter (products)
        recyclerView.adapter = productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL ="https://djemam.com/epsi/drink.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_CACHE)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                if(data !=null){
                    val jsOb= JSONObject(data)
                    val jsArray =jsOb.getJSONArray("items")
                    for(i in 0 until jsArray.length()){
                        val jsStudent = jsArray.getJSONObject(i)
                        val name =jsStudent.optString("name","")
                        val description =jsStudent.optString("description","")
                        val picture_url =jsStudent.optString("picture_url","")
                        val product = Product(name, description = description, picture_url = picture_url)
                        products.add(product)
                        Log.d("Student",product.name)
                    }
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })

                    Log.d("WS",data)
                    Log.d("Product","${products.size}")
                }
            }
        })
    }
}