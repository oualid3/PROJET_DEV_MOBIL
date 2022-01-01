package fr.epsi.project_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CategorieActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorie)
        showBtnBack()

        val buttonBoissons: Button = findViewById(R.id.buttonBoissons)
        val buttonFromages: Button = findViewById(R.id.buttonFromages)
        val buttonSurgeles: Button = findViewById(R.id.buttonSurgelés)
        val buttonSauces: Button = findViewById(R.id.buttonSauces)

        buttonBoissons.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,BoissonActivity::class.java)
            newIntent.putExtra("title",getString(R.string.txt_boissons))
            startActivity(newIntent)
        })
        buttonFromages.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,GroupeInfoActivity::class.java)
            newIntent.putExtra("title",getString(R.string.txt_fromages))
            startActivity(newIntent)
        })
        buttonSurgeles.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,GroupeInfoActivity::class.java)
            newIntent.putExtra("title",getString(R.string.txt_surgeles))
            startActivity(newIntent)
        })
        buttonSauces.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,GroupeInfoActivity::class.java)
            newIntent.putExtra("title",getString(R.string.txt_sauces))
            startActivity(newIntent)
        })

    }
}