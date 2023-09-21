package com.example.rps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),
    View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindListeners()
    }

    private fun bindListeners() {
        val buttons = listOf<Button>(
            findViewById(R.id.rock),
            findViewById(R.id.paper),
            findViewById(R.id.scissors)
        )
        buttons.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View?) {
        val bot = ButtonRPS.values().random()
        val button = v as Button
        val player = ButtonRPS.fromId(button.id)
        winScreen(findWinner(bot, player as ButtonRPS))
    }

    private fun findWinner(bot: ButtonRPS, player: ButtonRPS) : String{
        return when {
            bot.ordinal == player.ordinal -> "Draw"
            (player.ordinal - bot.ordinal == 1 )
                    or (bot.ordinal - player.ordinal == 2) -> "Win"
            else -> "Defeat"
        }
    }

    private fun winScreen(msg: String){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("result", msg)
        startActivity(intent)
    }
}

enum class ButtonRPS(val buttonId: Int) {
    ROCK(R.id.rock),
    PAPER(R.id.paper),
    SCISSORS(R.id.scissors);

    companion object {
        fun fromId(id: Int): ButtonRPS? {
            return values().find { it.buttonId == id }
        }
    }
}