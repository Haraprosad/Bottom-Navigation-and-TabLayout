package org.lingj.bottomnavigationandtablayout

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_motivation.view.*

/**
 * A simple [Fragment] subclass.
 */
class MotivationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_motivation, container, false)

        /**Step-01:Viewpager and Tablayout initialization and connects
         * each other.*/
    /*------------------------Start-------------------------*/

        //Initialization in fragment must be started view.x_id
        val viewPager = view.view_pager_id
        val tabLayout = view.tablayout_id

        //add fragments to viewpager adater(see the method below)
        setupViewPager(viewPager)

        //connecting tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager)

        /*--------------------End---------------------------*/


        return view
    }

    /**Step-02:Set viewPager adapter with the expected fragments.*/

    /*---------------------------Start-----------------------------*/
    private fun setupViewPager(viewPager: ViewPager) {

        //value assign in an adapter
        //Use a constructor to get access required methods
        val adapter = ViewPagerAdapter(childFragmentManager)
        //Creating resource for fragments and Tab Title
        adapter.addFragment(StudyMotivFragment(), "ONE")
        adapter.addFragment(HappinessMotivFragment(), "TWO")

        /*Connect viewPager_id(in our xml) contained adapter with this
        *  adapter.*/
        viewPager.adapter = adapter
    }

    /*------------------------End--------------------------------*/

    /**Step-03:Create an inner class with constructor
     *  to form adapter fully*/
    /*---------------------------Start-------------------------------*/
    inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        //Initialize fragments and tab titles related variables
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        //Assign fragment to the adapter (position wise)
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        //How much tab will be created is defined here
        override fun getCount(): Int {
            return mFragmentList.size
        }

        //Assign fragments and tab_titles value to variables
        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        //Tab Title assign(Position wise)
        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }


    }

    /*------------------------End------------------------------*/


}
