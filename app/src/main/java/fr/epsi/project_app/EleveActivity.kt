package fr.epsi.project_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class EleveActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleve)
        showBtnBack()
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        val imageViewDetail = findViewById<ImageView>(R.id.imageViewDetail)
        val urlImage= intent.getStringExtra("urlImage")
        Picasso.get().load(urlImage).into(imageViewDetail)

    }
}