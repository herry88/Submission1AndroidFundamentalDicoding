package com.example.githubapps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_user.view.*
import java.security.AccessControlContext

class UserAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var users = arrayListOf<User>()

    private inner class ViewHolder internal constructor(private val view: View){
        internal fun bind(user : User){
            with(view){
                txtusername.text = user.username
                txtname.text = user.name
                txtrepository.text = user.repository
                txtcompany.text =user.company
                txtlocation.text = user.location
                txtfollowers.text = user.followers
                txtfollowing.text = user.following
                img_user.setImageResource(user.avatar)
            }
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        TODO("Not yet implemented")
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent,false)
        }

        var viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    override fun getItem(position: Int): Any = users[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = users.size

}
