package com.example.wizelineonsitechallenge.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.wizelineonsitechallenge.R
import com.example.wizelineonsitechallenge.model.Timeline
import com.example.wizelineonsitechallenge.model.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.new_tweet_layout.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class NewTweetActivity: AppCompatActivity() {

    private lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_tweet_layout)
        getArguments()
        setUI()
    }

    private fun getArguments() {
        intent.extras?.let{
            mUser = it.getSerializable("USER") as User
        }
    }

    private fun setUI() {
        et_new_tweet.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    tv_characters.apply {
                        val mText = "${s?.length?.let { 140 - it}} caracteres"
                        text = mText
                    }
                }
            })
        btn_submit.apply {
            setOnClickListener {
                if(validEditText()) {
                    val id = ThreadLocalRandom.current().nextDouble()
                    val tweet = Timeline(id = id,
                        id_str = id.toString(),
                        created_at = getCurrentTimeStamp() ?: "",
                        text = "Erik Inserto este Tweet",
                        user = mUser)

                }
            }
        }
    }



    private fun validEditText(): Boolean {
        return et_new_tweet.text.toString().isNotEmpty()
    }

    private fun getCurrentTimeStamp(): String? {
        val sdfDate = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z",Locale("es","MX"))
        val now = Date()
        return sdfDate.format(now)
    }
}