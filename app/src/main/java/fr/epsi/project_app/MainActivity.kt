package fr.epsi.project_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showBtnBack()

        val buttonZone1: Button = findViewById(R.id.buttonZone1)
        val buttonZone2: Button = findViewById(R.id.buttonZone2)

        buttonZone1.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,GroupeInfoActivity::class.java)
            startActivity(newIntent)
        })

        buttonZone2.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,GroupeInfoActivity::class.java)
            startActivity(newIntent)
        })
    }
}