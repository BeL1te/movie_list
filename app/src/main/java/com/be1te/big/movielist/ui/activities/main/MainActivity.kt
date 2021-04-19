package com.be1te.big.movielist.ui.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.be1te.big.movielist.databinding.ActivityMainBinding
import com.be1te.big.movielist.model.DataFilm
import com.be1te.big.movielist.utilities.ARRAY

class MainActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainActivityViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: FilmAdapter
    private lateinit var list: List<DataFilm>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        mToolbar = mBinding.toolbar
        setSupportActionBar(mToolbar)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initialize()
    }

    private fun initialize() {
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        list = ARRAY
        mAdapter = FilmAdapter(this)
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mAdapter.setList(list)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        mRecyclerView.adapter = null
    }
}