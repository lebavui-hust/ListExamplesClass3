package vn.edu.hust.listexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<String>()
        repeat(50) {
            items.add("Item $it")
        }

        val adapter1 = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, items
        )

        val adapter2 = ArrayAdapter(
            this,
            R.layout.layout_string_item,
            R.id.text_content,
            items
        )

        val words: Array<String> = arrayOf("words", "starting", "with", "set",
            "Setback", "Setline", "Setoffs", "Setouts", "Setters", "Setting",
            "Settled", "Settler", "Wordless", "Wordiness", "Adios")

        val adapter3 = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, words
        )

        val autoEditText = findViewById<AutoCompleteTextView>(R.id.auto_edit_text)
        autoEditText.setAdapter(adapter3)
    }
}
