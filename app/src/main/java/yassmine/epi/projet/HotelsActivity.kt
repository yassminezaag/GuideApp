package yassmine.epi.projet

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HotelsActivity : AppCompatActivity() {

    lateinit var recycleViewHotels : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)




        recycleViewHotels = findViewById(R.id.recycleViewHotels)

        val items = listOf(
            hotel(R.drawable.elksar,"Karthago El Ksar (El Ksar Resort &amp; Thalasso)",3.5F,"4-star hotel","Address: Bd du 14 Janvier, Sousse 4031","Phone: 73 240 460"),
            hotel(R.drawable.rosa,"Rosa Beach Thalasso and Spa",3.6F,"4-star hotel","Address: Rue de L'Aeroport Skanes Monastir, 5000","Phone: 73 520 088"),
            hotel(R.drawable.marhababeach,"Hotel Marhaba Beach",4.1F,"4-star hotel","Address: Bd du 14 Janvier, Sousse 4039","Phone: 73 240 112"),
            hotel(R.drawable.moven,"Mövenpick Sousse",4.2F,"5-star hotel","Address: Bd du 14 Janvier, Sousse 4039","Phone: 73 202 000"),
            hotel(R.drawable.tej,"Tej Marhaba",3.3F,"4-star hotel","Address: Avenue Taïeb M'hiri, Sousse 4001","Phone: 73 229 800")

            )

        recycleViewHotels.apply {
            layoutManager = LinearLayoutManager(this@HotelsActivity)
            adapter = HotelAdapter(items)
        }




    }
}