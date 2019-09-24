package org.lingj.bottomnavigationandtablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**Code for Bottom Navigation*/
        /*--------------------Start----------------------*/
        if(savedInstanceState==null){
            val fragment = HomeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frmlayout_nav_container_id,
                fragment,fragment.javaClass.simpleName).commit()
        }

        val navListener = BottomNavigationView.OnNavigationItemSelectedListener {item->

            when(item.itemId){
                R.id.itm_home->{
                    val fragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frmlayout_nav_container_id,
                        fragment,fragment.javaClass.simpleName).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.itm_motivation->{
                    val fragment = MotivationFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frmlayout_nav_container_id,
                        fragment,fragment.javaClass.simpleName).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.itm_improvement->{
                    val fragment = ImprovementFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frmlayout_nav_container_id,
                        fragment,fragment.javaClass.simpleName).commit()
                    return@OnNavigationItemSelectedListener true
                }
                else -> return@OnNavigationItemSelectedListener false
            }
        }

        btm_navigation_id.setOnNavigationItemSelectedListener(navListener)
        /*--------------------End----------------------*/
    }
}
