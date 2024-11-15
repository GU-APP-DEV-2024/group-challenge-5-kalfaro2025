package com.zybooks.workingwithdata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExoPlanet : AppCompatActivity() {

    data class MarsRoverPhotos(val sol: Int, val totalPhotos: Int, val camera: Array<String>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MarsRoverPhotos

            if (sol != other.sol) return false
            if (totalPhotos != other.totalPhotos) return false
            if (!camera.contentEquals(other.camera)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = sol
            result = 31 * result + totalPhotos
            result = 31 * result + camera.contentHashCode()
            return result
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exo_planet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var dummyDataSet =arrayListOf<MarsRoverPhotos>(MarsRoverPhotos(0, 3702, arrayOf("CHEMCAM", "FHAZ", "MARDI", "RHAZ")),
            MarsRoverPhotos(2, 3350, arrayOf("NAVCAM", "MINITES", "MARDI")),
            MarsRoverPhotos(7, 14, arrayOf("MAST", "MAHLI", "FHAZ")))
    }
}