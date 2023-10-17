package yassmine.epi.projet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class ConvertisseurActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convertisseur)


        val WebConv = findViewById<WebView>(R.id.webView)

        WebConv.apply {
            loadUrl("https://www.xe.com/fr/currencyconverter/")
            settings.javaScriptEnabled = true
        }
    }
}