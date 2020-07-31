package com.example.wizelineonsitechallenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.wizelineonsitechallenge.R
import com.example.wizelineonsitechallenge.adapter.TweetAdapter
import com.example.wizelineonsitechallenge.model.Timeline
import com.example.wizelineonsitechallenge.model.User
import com.example.wizelineonsitechallenge.util.DataState
import com.example.wizelineonsitechallenge.viewmodel.MainStateEvent
import com.example.wizelineonsitechallenge.viewmodel.MainViewModelTwo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.io.Serializable

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mUser: User
    private val viewModel: MainViewModelTwo by viewModels()
    private val TAG = MainActivity::class.java.canonicalName
    private lateinit var tweetAdapter: TweetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
        subscribeObservers()
        getNetworkData()
    }

    //Subscribe my observables
    private fun subscribeObservers() {
        //User Observer
        viewModel.userDataState.observe(this, Observer {userDataState ->
            when(userDataState){
                is DataState.Success<User> ->{
                    displayProgressBar(false)
                    setUserInfo(userDataState.data)
                }
                is DataState.Loading ->{
                    displayProgressBar(true)
                }
                is DataState.Error ->{
                    displayProgressBar(false)
                    displayError(message = userDataState.exception.message)
                }
            }
        })

        //Timeline Observer
        viewModel.timelineDataState.observe(this, Observer {timelineDataState ->
            when(timelineDataState){
                is DataState.Success<List<Timeline>> ->{
                    displayProgressBar(false)
                    setRecyclerViewInfo(timelineDataState.data)
                }
                is DataState.Loading ->{
                    displayProgressBar(true)
                }
                is DataState.Error ->{
                    displayProgressBar(false)
                    displayError(message = timelineDataState.exception.message)
                }
            }
        })
    }

    private fun setUI() {
        rv_tweets.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(false)
            tweetAdapter = TweetAdapter(this@MainActivity, emptyList())
            adapter = tweetAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
    }

    private fun setRecyclerViewInfo(tweetList: List<Timeline>) {
        tweetAdapter.updateList(tweetList)
    }

    private fun setUserInfo(user: User) {
        mUser = user
        iv_user.apply {
            Glide.with(context)
                .load(user.profile_image_url_https)
                .into(this)
        }
        tv_user_name.apply {
            text = user.name
        }
    }

    //Displaying ProgressBar
    private fun displayProgressBar(isDisplayed: Boolean){
        progress_bar.apply {
            visibility = if(isDisplayed) View.VISIBLE else View.GONE
        }
    }

    //Error Managing
    private fun displayError(message: String?) {
        val builder: AlertDialog.Builder? = this.let {
            AlertDialog.Builder(it)
        }
        message?.let {errorMsg ->
            builder?.
            setMessage(errorMsg)?.
            setTitle(R.string.error_title)
        }
    }

    //ViewModels data request
    private fun getNetworkData() {
        viewModel.setUserStateEvent(MainStateEvent.GetUserEvent)
        viewModel.setTimelineStateEvent(MainStateEvent.GetTimelineEvent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.newTweet -> {
                val intent = Intent(this,NewTweetActivity::class.java)
                intent.putExtra("USER",mUser)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}