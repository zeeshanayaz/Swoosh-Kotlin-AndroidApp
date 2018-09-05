package com.example.zeeshan.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.zeeshan.swoosh.Utilities.EXTRA_LEAGUE
import com.example.zeeshan.swoosh.R
import com.example.zeeshan.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var selectedSkill = ""
    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println("Selected League is $league")
    }


    fun onBeginnerClicked(view: View){
        ballerToggleBtn.isChecked = false

        selectedSkill = "beginner"
    }

    fun onBallerClicked(view: View){
        beginnerToggleBtn.isChecked = false

        selectedSkill = "baller"
    }

    fun onSkillFinishClicked(view: View){
        if (ballerToggleBtn.isChecked == true || beginnerToggleBtn.isChecked == true){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, selectedSkill)

            startActivity(finishActivity)
        }else{
            Toast.makeText(this, "Please Select a skill Level", Toast.LENGTH_SHORT).show()
        }
    }
}
