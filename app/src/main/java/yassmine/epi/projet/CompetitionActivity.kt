package yassmine.epi.projet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompetitionActivity : AppCompatActivity() {

    lateinit var recycleViewMatchs : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition)

        recycleViewMatchs = findViewById(R.id.recycleViewMatchs)


        val items = listOf(
            Match("06/01/2023","Tunisie",R.drawable.tunisia,"16:00",R.drawable.yemen,"Yemen"),
            Match("07/01/2023","Algérie",R.drawable.algeria,"12:00",R.drawable.egypt,"Egypte"),
            Match("09/01/2023","Tunisie",R.drawable.tunisia,"10:00",R.drawable.morocco,"Morocco"),
            Match("11/01/2023","Egypte",R.drawable.egypt,"17:00",R.drawable.lebanon,"Lebanon"),
            Match("12/01/2023","Sudan",R.drawable.sudan,"16:00",R.drawable.algeria,"Algérie"),
            Match("15/01/2023","Lebanon",R.drawable.lebanon,"14:00",R.drawable.egypt,"Egypte"),
            Match("20/01/2023","Sudan",R.drawable.sudan,"16:00",R.drawable.tunisia,"Tunisie"),
            Match("21/01/2023","Qatar",R.drawable.qatar,"16:00",R.drawable.iraq,"Iraq"),

            )

        recycleViewMatchs.apply {
            layoutManager = LinearLayoutManager(this@CompetitionActivity)
            adapter = MatchAdapter(items)
        }
    }


}