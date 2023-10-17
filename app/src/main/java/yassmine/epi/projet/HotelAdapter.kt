package yassmine.epi.projet

import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HotelAdapter(var items: List<hotel>) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
          val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hotels, parent,false)
          return HotelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = items[position]
        holder.bind(hotel)

    }

    override fun getItemCount()= items.size

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var nomHotel: TextView
         var txtRating: TextView
         var adress: TextView
         var tel: TextView
         var imageHotel: ImageView
         var ratingBar: RatingBar

        init {
            nomHotel = itemView.findViewById(R.id.nomHotel)
            txtRating = itemView.findViewById(R.id.txtRating)
            adress = itemView.findViewById(R.id.adress)
            tel = itemView.findViewById(R.id.tel)
            imageHotel = itemView.findViewById(R.id.imageHotel)
            ratingBar = itemView.findViewById(R.id.ratingBar)
        }

        fun bind(hotel: hotel){
            nomHotel.text = hotel.nom
            imageHotel.setImageResource(hotel.image)
            txtRating.text= hotel.txtrating
            adress.text = hotel.address
            tel.text= hotel.tel
            ratingBar.rating = hotel.rating
        }


    }

}