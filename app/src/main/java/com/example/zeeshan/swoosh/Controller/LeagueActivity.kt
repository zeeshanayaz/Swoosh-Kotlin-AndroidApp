package com.example.zeeshan.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.zeeshan.swoosh.Model.Player
import com.example.zeeshan.swoosh.R
import com.example.zeeshan.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

//    var selectedLeague = ""

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onMensClicked(view: View){
        womensLeagueToggleBtn.isChecked = false
        coEdLeagueToggleBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueToggleBtn.isChecked = false
        coEdLeagueToggleBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoEdClicked(view: View){
        mensLeagueToggleBtn.isChecked = false
        womensLeagueToggleBtn.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClick(view : View){

        if(player.league != "" || mensLeagueToggleBtn.isChecked == true || womensLeagueToggleBtn.isChecked == true || coEdLeagueToggleBtn.isChecked == true){
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        }else{
            Toast.makeText(this, "Please Select a League", Toast.LENGTH_SHORT).show()
        }
    }
}
