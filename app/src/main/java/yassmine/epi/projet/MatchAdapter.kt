package yassmine.epi.projet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchAdapter(var items: List<Match>) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_boucle, parent, false)
            return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
          val match = items[position]
        holder.bind(match)

    }

    override fun getItemCount() = items.size

   inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


         var tvJour: TextView
         var tvtext1 : TextView
         var tvImg1 : ImageView
         var tvHeure : TextView
         var tvImg2 : ImageView
         var tvText2: TextView

        init {
            tvJour = itemView.findViewById(R.id.tvJour)
            tvtext1 = itemView.findViewById(R.id.tvText1)
            tvImg1 = itemView.findViewById(R.id.tvImg1)
            tvHeure = itemView.findViewById(R.id.tvHeure)
            tvImg2 = itemView.findViewById(R.id.tvImg2)
            tvText2 = itemView.findViewById(R.id.tvText2)
        }

        fun bind(match: Match) {
            tvJour.text = match.jour
            tvtext1.text = match.texte1
            tvText2.text= match.texte2
            tvHeure.text = match.heure
            tvImg1.setImageResource(match.img1)
            tvImg2.setImageResource(match.img2)

        }
    }



}