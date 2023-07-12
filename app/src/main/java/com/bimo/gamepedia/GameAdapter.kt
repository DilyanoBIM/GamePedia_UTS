package com.bimo.gamepedia

import android.view.LayoutInflater
import android.content.Context

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter (private val context: Context, val GameList: ArrayList<Game>, val listener: (Game) -> Unit): RecyclerView.Adapter<GameAdapter.GameViewHolder>(){
    class GameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imgGame : ImageView = itemView.findViewById(R.id.ivImage)
        val nameGame : TextView =  itemView.findViewById(R.id.tvName)
        val descGame : TextView = itemView.findViewById(R.id.tvDesc)

        fun bindView(game: Game, listener: (Game) -> Unit){imgGame.setImageResource(game.imgGame)

            nameGame.text = game.nameGame
            descGame.text = game.descGame
            itemView.setOnClickListener{
                listener(game)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(itemView)}

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val currentItem = GameList[position]

        holder.imgGame.setImageResource(currentItem.imgGame)

        holder.nameGame.text = (currentItem.nameGame)
        holder.descGame.text = (currentItem.descGame)
        holder.bindView(GameList[position], listener)

    }

    override fun getItemCount(): Int {
        return GameList.size
    }



}
