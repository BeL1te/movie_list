package com.be1te.big.movielist.ui.activities.main

import android.app.*
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.be1te.big.movielist.R
import com.be1te.big.movielist.model.DataFilm
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.film_item.view.*

class FilmAdapter(val context: Context) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    private var mDataFilm = emptyList<DataFilm>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mDataFilm.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mDataFilm[position])
    }

    fun setList(list: List<DataFilm>) {
        mDataFilm = list
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

        fun bind(film: DataFilm) {
            itemView.title_film.text = film.title
            itemView.content_film.text = film.overview
            itemView.date_film.text = film.date
            itemView.progress_bar.progress = (film.rating * 10).toInt()
            itemView.score.text = film.rating.toString()
            Glide.with(context).load("https://image.tmdb.org/t/p/w500" + film.poster)
                .into(itemView.image_film)
            itemView.btn_push.setOnClickListener {
                val datePickerDialog =
                    DatePickerDialog(context, this, 2019, 1, 1)
                datePickerDialog.show()
            }
        }

        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            val timePickerDialog =
                TimePickerDialog(context, this, 12, 0, true)
            timePickerDialog.show()
        }

        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

        }

//        private fun createNotificationChannel() {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                val name: CharSequence = "Best film of 2019"
//                val description = "List of best films of 2019"
//                val importance = NotificationManager.IMPORTANCE_DEFAULT
//                val channel = NotificationChannel("notify", name, importance)
//                channel.description = description
//
//                val manager = getSystemService(NotificationManager::class.java)
//
//            }
//        }
    }
}