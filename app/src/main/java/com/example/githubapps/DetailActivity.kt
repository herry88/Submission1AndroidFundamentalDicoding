package com.example.githubapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user = intent.getParcelableExtra(EXTRA_USER) as User
        img_user.setImageResource(user.avatar)
        txtusername.text = user.username
        txtname.text = user.name
        txtrepository.text = user.repository
        txtcompany.text = user.company
        txtlocation.text = user.location
        txtfollowers.text = user.followers
        txtfollowing.text = user.following
    }
}