package com.example.zeeshan.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.zeeshan.swoosh.Model.Player
import com.example.zeeshan.swoosh.R
import com.example.zeeshan.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

//    var selectedSkill = ""
//    var league = ""

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }


    fun onBeginnerClicked(view: View){
        ballerToggleBtn.isChecked = false

        player.skill = "beginner"
    }

    fun onBallerClicked(view: View){
        beginnerToggleBtn.isChecked = false

        player.skill = "baller"
    }

    fun onSkillFinishClicked(view: View){
        if (ballerToggleBtn.isChecked == true || beginnerToggleBtn.isChecked == true){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)

            startActivity(finishActivity)
        }else{
            Toast.makeText(this, "Please Select a skill Level", Toast.LENGTH_SHORT).show()
        }
    }
}
