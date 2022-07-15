package ru.neoslax.loadauto.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.neoslax.loadauto.R
import ru.neoslax.loadauto.databinding.ActivityMainBinding
import ru.neoslax.loadauto.presentation.adapters.CarListAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (application as LoadAutoApp).component
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRv()
    }

    private fun setupRv() {
        val adapter = CarListAdapter()
        adapter.onItemClick = {
            startActivity(
                MapActivity.newIntent(
                    this,
                    it.lat ?: 0.0,
                    it.lon ?: 0.0
                )
            )
        }
        binding.rvMain.adapter = adapter
        viewModel.carList.observe(this) {
            adapter.submitList(it)
        }
    }
}