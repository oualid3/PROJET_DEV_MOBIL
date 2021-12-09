package fr.epsi.project_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupeInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groupe_info)
        showBtnBack()

        val buttonEleve: Button = findViewById(R.id.buttonEleve)

        buttonEleve.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,EleveActivity::class.java)
            newIntent.putExtra("title",getString(R.string.nom_eleve))
            newIntent.putExtra("urlImage","https://cdn-icons-png.flaticon.com/512/190/190600.png")
            startActivity(newIntent)
        })
    }
}