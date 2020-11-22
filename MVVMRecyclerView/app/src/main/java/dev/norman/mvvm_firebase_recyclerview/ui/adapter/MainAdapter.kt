package dev.norman.mvvm_firebase_recyclerview.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.norman.mvvm_firebase_recyclerview.R
import dev.norman.mvvm_firebase_recyclerview.data.model.UserEntity
import dev.norman.mvvm_firebase_recyclerview.databinding.ItemRecyclerviewBinding

/**
 * Created by normansn on 22/11/20.
 */
class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var listData: MutableList<UserEntity> = mutableListOf()

    fun setData(listData: MutableList<UserEntity>) {
        this.listData.clear()
        this.listData = listData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewBinding.inflate(layoutInflater)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listData[position])
    }

    override fun getItemCount(): Int = if (listData.size > 0) listData.size else 0

    inner class ViewHolder(private val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root){

        fun bindView(userEntity: UserEntity) = with(binding) {
            Glide.with(context).load(userEntity.imageUrl).into(circleImageView)
            tvTitle.text = userEntity.name
            tvDescription.text= userEntity.description
        }
    }
}