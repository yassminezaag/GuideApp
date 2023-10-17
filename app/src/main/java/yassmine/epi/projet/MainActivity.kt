package yassmine.epi.projet

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.util.Pair as UtilPair
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN



        //Declare the animation
        val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        val img = findViewById<ImageView>(R.id.imageView)
        val logo = findViewById<TextView>(R.id.textView)

        // Start animation
        img.startAnimation(topAnim)
        logo.startAnimation(bottomAnim)

        handler= Handler()
        handler.postDelayed({
            val intent=Intent(this,LoginActivity::class.java)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val options =
                    ActivityOptions.makeSceneTransitionAnimation(this,
                        UtilPair.create(img, "logo_image"),
                        UtilPair.create(logo, "logo_text"))

                    startActivity(intent, options.toBundle())
                    finish()

            }
        },3000)

    }
}