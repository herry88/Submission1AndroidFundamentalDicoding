package com.example.githubapps

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var dataUsername:Array<String>
    private lateinit var dataName:Array<String>
    private lateinit var dataLocation:Array<String>
    private lateinit var dataRepository:Array<String>
    private lateinit var dataCompany:Array<String>
    private lateinit var dataFollowers:Array<String>
    private lateinit var dataFollowing:Array<String>
    private lateinit var dataAvatar:TypedArray

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(this)
        lv_user.adapter = adapter

        prepare()
        init()

        lv_user.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            val user = User(
                users[position].avatar,
                users[position].username,
                users[position].name,
                users[position].repository,
                users[position].company,
                users[position].followers,
                users[position].following,
                users[position].location
            )
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_USER, user)
            startActivity(intent)
        }
    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)

    }

    private fun init() {
        for (position in dataName.indices){
            val user = User(
                dataAvatar.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}
