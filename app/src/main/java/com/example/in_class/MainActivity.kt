package com.example.in_class

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Adding in our own Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    //Adding menu functionality returns true if our menu item false if it isn't
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.action_take_picture -> Toast.makeText(this, "Clicked Take Picture Option", Toast.LENGTH_SHORT).show()
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
            R.id.action_delete_picture -> {
                AlertDialog.Builder(this)
                    .setTitle("Delete Confirmation")
                    .setMessage("Are you sure you want to delete this picture?")
                    .setPositiveButton("Yes"){_,_ -> Toast.makeText(this, "Picture Deleted", Toast.LENGTH_SHORT).show()}
                    .setNegativeButton("No"){_,_ -> Toast.makeText(this, "Not Deleted", Toast.LENGTH_SHORT).show()}
                    .setCancelable(false)
                    .create()
                    .show()
            }

        }

        return super.onOptionsItemSelected(item)
    }
}