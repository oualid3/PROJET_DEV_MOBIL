package fr.epsi.project_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GroupeInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groupe_info)
        showBtnBack()
        setHeaderTitle("Groupe Info")
    }
}