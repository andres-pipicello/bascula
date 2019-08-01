package com.github.bascula

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.github.bascula.fragments.InputFragment
import com.github.bascula.presistence.Database
import com.github.bascula.fragments.TableFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.everything_layout)
//        val fragment = TableFragment()
//        val fragment = InputFragment()
//        supportFragmentManager.beginTransaction().add(R.id.activity_container, fragment).commit()

        val db: Database = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "database-name"
        ).fallbackToDestructiveMigration().build()

        db.measurements()
    }



}