package com.example.umbjm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    lateinit var toogle:ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val drawerLayout:DrawerLayout = findViewById(R.id.drawer_layout)
        val navView:NavigationView=findViewById(R.id.nav_view)


        toogle =ActionBarDrawerToggle(this,drawerLayout,0,0)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title= "Univeristas Muhammadiyah Banjarmasin"

        replaceFragment(BerandaFragment(),"")

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.beranda -> replaceFragment(BerandaFragment(),it.title.toString())
                R.id.profile -> replaceFragment(ProfilFragment(),it.title.toString())
                R.id.fakultas-> replaceFragment(FakultasFragment(),it.title.toString())
                R.id.akreditasi -> replaceFragment(AkreditasFragment(),it.title.toString())
            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment, title:String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}