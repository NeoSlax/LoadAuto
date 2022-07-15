package ru.neoslax.loadauto.presentation

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import ru.neoslax.loadauto.R
import ru.neoslax.loadauto.databinding.ActivityMapBinding
import ru.neoslax.loadauto.utils.getBitmapFromVectorDrawable

class MapActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityMapBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.initialize(this)
        setContentView(binding.root)
        checkIntent()
        Toast.makeText(
            this, "lat: ${intent.getDoubleExtra(LAT, 0.0)}, lon: ${
                intent.getDoubleExtra(
                    LON, 0.0
                )
            }", Toast.LENGTH_SHORT
        ).show()


        val targetPoint = Point(parseLat(), parseLon())
        val animation = Animation(Animation.Type.SMOOTH, 0f)
        binding.mapview.map.move(CameraPosition(targetPoint, 11f, 0f, 0f), animation, null)
        val bitmap = getBitmapFromVectorDrawable(R.drawable.ic_baseline_place_24)
        binding.mapview.map.mapObjects.addPlacemark(targetPoint, ImageProvider.fromBitmap(bitmap))
    }



    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    private fun checkIntent() {
        if (!(intent.hasExtra(LAT) && intent.hasExtra(LON))) finish()
    }

    private fun parseLon(): Double {
        return intent.getDoubleExtra(LON, DEF_VAL)
    }

    private fun parseLat(): Double {
        return intent.getDoubleExtra(LAT, DEF_VAL)
    }


    companion object {
        fun newIntent(
            context: Context,
            lat: Double,
            lon: Double
        ): Intent = Intent(context, MapActivity::class.java).apply {
            putExtra(LAT, lat)
            putExtra(LON, lon)
        }

        private const val LON = "lon"
        private const val LAT = "lat"

        private const val DEF_VAL = 0.0
    }
}