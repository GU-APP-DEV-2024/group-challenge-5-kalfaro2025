package com.zybooks.workingwithdata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.zybooks.workingwithdata.NasaAPI.ImageData
import org.json.JSONArray

class ExoPlanet : AppCompatActivity() {

    lateinit var startDateTextView: TextView
    lateinit var startDateEditText: EditText
    lateinit var endDateTextView: TextView
    lateinit var endDateEditText: EditText
    private lateinit var recyclerView: RecyclerView
    lateinit var imageDataSet: ArrayList<ImageData>
    private lateinit var imageCustomAdapter: ImageCustomAdapter2
    lateinit var countEditText: EditText

    data class EarthQuery(val lat: Double, val lon: Double, val dim: Double, val date: String)

    data class EarthResponse(val date: String, val url: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exo_planet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var dummyQuerySet =arrayListOf<EarthQuery>(
            EarthQuery(0.0, -12.5, 0.025, "2020-01-01"),
            EarthQuery(50.0, -0.5, 0.025, "2020-01-02"),
            EarthQuery(79.0, 12.5, 0.025, "2020-01-03"),
            EarthQuery(360.0, -100.2, 0.025, "2020-01-04"),
            EarthQuery(56.0, 400.5, 0.025, "2020-01-05"),
            EarthQuery(400.0, -0.5, 0.025, "2020-01-06"),
            EarthQuery(342.0, 68.5, 0.025, "2020-01-07"),
            EarthQuery(192.0, -100.2, 0.025, "2020-01-08"),
            EarthQuery(28.0, 128.0, 0.025, "2020-01-09"),)

        val dummyResponseSet =arrayListOf<EarthResponse>(
            EarthResponse("2020-01-01", "https://example.com/1"),
            EarthResponse("2020-01-02", "https://example.com/2"),
            EarthResponse("2020-01-03", "https://example.com/3"),
            EarthResponse("2020-01-04", "https://example.com/4"),
            EarthResponse("2020-01-05", "https://example.com/5"),
            EarthResponse("2020-01-06", "https://example.com/6"),
            EarthResponse("2020-01-07", "https://example.com/7"),
            EarthResponse("2020-01-08", "https://example.com/8"),
            EarthResponse("2020-01-09", "https://example.com/9"),)

        imageCustomAdapter = ImageCustomAdapter2(dummyResponseSet)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = imageCustomAdapter
    }
}