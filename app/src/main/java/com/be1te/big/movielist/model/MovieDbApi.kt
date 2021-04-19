package com.be1te.big.movielist.model

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class MovieDbApi {
    fun getListOfFilms(context: Context, url: String): List<DataFilm> {
        val mQueue = Volley.newRequestQueue(context)
        var list = ArrayList<DataFilm>()
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val jsonArray = response.getJSONArray("results")
                for (i in 0 until jsonArray.length()) {
                    val film = jsonArray.getJSONObject(i)
                    val title = film.getString("title")
                    val overview = film.getString("overview")
                    val poster = film.getString("poster_path")
                    val date = film.getString("release_date")
                    val rating = film.getDouble("vote_average")
                    list.add(DataFilm(title, overview, poster, date, rating))
                }
            },
            Response.ErrorListener {
                list.add(
                    DataFilm(
                        "Большая ошибка",
                        "Это большая ошибка, которая должна быть обработана",
                        "",
                        "666-66-66",
                        9.9
                    )
                )
            })
        mQueue.add(request)
        return list
    }
}