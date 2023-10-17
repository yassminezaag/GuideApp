package yassmine.epi.projet

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val CallSingUp = findViewById<Button>(R.id.btn_callSignUp)
        val logo_image = findViewById<ImageView>(R.id.logo_image)
        val logo_name = findViewById<TextView>(R.id.logo_name)
        val slogantext = findViewById<TextView>(R.id.slogan_name)
        val username = findViewById<TextInputLayout>(R.id.username)
        val password = findViewById<TextInputLayout>(R.id.password)
        val login_btn = findViewById<Button>(R.id.login_btn)
        val eduser = findViewById<TextInputEditText>(R.id.edusername)
        val edpassword = findViewById<TextInputEditText>(R.id.edpassword)


        val intent = Intent(this, SignUpActivity::class.java)
        CallSingUp.setOnClickListener {
            val options =
                ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair.create(logo_image, "logo_image"),
                    Pair.create(logo_name, "logo_text")
                )
            Pair.create(slogantext, "logo_desc")
            Pair.create(username, "username_tran")
            Pair.create(password, "password_tran")
            Pair.create(login_btn, "btnGo_tran")
            startActivity(intent, options.toBundle())
        }

        val intent_login = Intent(this, MenuActivity::class.java)
        login_btn.setOnClickListener {
            if (edpassword.text.toString() =="admin" && eduser.text.toString()=="admin")

                startActivity(intent_login)
            else if (eduser.text.toString().isEmpty() && edpassword.text.toString().isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please Enter Your Username & Password",
                    Toast.LENGTH_LONG
                ).show()
            } else
                Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_LONG).show()

        }
    }
}



