package com.be1te.big.movielist.ui.activities.main

import android.app.Application
import android.app.VoiceInteractor
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.be1te.big.movielist.model.DataFilm
import com.be1te.big.movielist.model.MovieDbApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
   // fun getFilm(context: Context, url: String): List<DataFilm> = MovieDbApi().getListOfFilms(context, url)
}