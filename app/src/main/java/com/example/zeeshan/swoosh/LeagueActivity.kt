package com.example.zeeshan.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View){
        womensLeagueToggleBtn.isChecked = false
        coEdLeagueToggleBtn.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueToggleBtn.isChecked = false
        coEdLeagueToggleBtn.isChecked = false

        selectedLeague = "womens"
    }

    fun onCoEdClicked(view: View){
        mensLeagueToggleBtn.isChecked = false
        womensLeagueToggleBtn.isChecked = false

        selectedLeague = "co-ed"
    }

    fun leagueNextClick(view : View){

        if(mensLeagueToggleBtn.isChecked == true || womensLeagueToggleBtn.isChecked == true || coEdLeagueToggleBtn.isChecked == true){
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillIntent)
        }else{
            Toast.makeText(this, "Please Select a League", Toast.LENGTH_SHORT).show()

        }
//        if(selectedLeague != ""){
//            val skillIntent = Intent(this, SkillActivity::class.java)
//            startActivity(skillIntent)
//        }else{
//            Toast.makeText(this, "Please Select a League", Toast.LENGTH_SHORT).show()
//
//        }
    }
}
