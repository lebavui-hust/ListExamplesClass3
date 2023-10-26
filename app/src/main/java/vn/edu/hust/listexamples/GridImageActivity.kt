package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class GridImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_image)

        val images = arrayListOf<Int>()
        repeat(28) {
            val index = it + 1
            images.add(resources.getIdentifier("thumb$index", "drawable", packageName))
        }

        val adapter = ImageAdapter(images)
        findViewById<GridView>(R.id.grid_view).adapter = adapter
    }
}