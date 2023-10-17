package yassmine.epi.projet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_Goback=findViewById<Button>(R.id.btn_GobacktoLogin)
        val intent=Intent(this,LoginActivity::class.java)
        btn_Goback.setOnClickListener {
            startActivity(intent)
        }







    }
}