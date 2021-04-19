package com.be1te.big.movielist.ui.activities.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.be1te.big.movielist.databinding.ActivityMainBinding
import com.be1te.big.movielist.model.MovieDbApi
import com.be1te.big.movielist.ui.activities.main.MainActivity
import com.be1te.big.movielist.utilities.ARRAY
import com.be1te.big.movielist.utilities.URL

class StartActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        ARRAY = MovieDbApi().getListOfFilms(this, URL)
        Handler().postDelayed({
            val intent = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}