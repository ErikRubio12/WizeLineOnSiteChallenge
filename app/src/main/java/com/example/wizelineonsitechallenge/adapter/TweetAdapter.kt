package com.example.wizelineonsitechallenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wizelineonsitechallenge.R
import com.example.wizelineonsitechallenge.model.Timeline
import kotlinx.android.synthetic.main.tweet_item.view.*

class TweetAdapter(
    var context: Context,
    var listTweets: List<Timeline>): RecyclerView.Adapter<RecyclerView.ViewHolder>()    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.tweet_item,parent,false)
        return TweetViewHolder(v)
    }

    override fun getItemCount(): Int = listTweets.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val tweetHolder = holder as TweetViewHolder
        tweetHolder.tvText.apply {
            text = listTweets[position].text
        }
        tweetHolder.tvUserName.apply {
            val username = "@${listTweets[position].user.screen_name}"
            text = username
        }
        tweetHolder.tvTime.apply {
            text = listTweets[position].created_at
        }
        tweetHolder.ivTweet.apply {
            Glide.with(context)
                .load(listTweets[position].user.profile_image_url_https)
                .into(this)
        }
    }

    fun updateList(tweetList: List<Timeline>){
        this.listTweets = tweetList
        notifyDataSetChanged()
    }

    inner class TweetViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivTweet: ImageView = itemView.iv_tweet
        val tvUserName: TextView = itemView.tv_username
        val tvText: TextView = itemView.tv_text
        val tvTime: TextView = itemView.tv_time
    }
}