package fr.epsi.epsig2.fr.epsi.project_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.epsi.project_app.AppEpsi
import fr.epsi.project_app.R

class ProductAdapter (private val product: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textViewName = view.findViewById<TextView>(R.id.tewtViewName)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewDescription)
        val imageBoisson = view.findViewById<ImageView>(R.id.imageBoisson)
        val boisson = view.findViewById<LinearLayout>(R.id.boisson)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_produit, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = product.get(position)
        holder.textViewName.text=product.name
        holder.textViewDescription.text=product.description

        Picasso.get().load(product.picture_url).into(holder.imageBoisson)
        holder.boisson.setOnClickListener(View.OnClickListener {
            (holder.boisson.context.applicationContext as AppEpsi).showToast(product.name)
        })
    }

    override fun getItemCount(): Int {
        return product.size
    }
}