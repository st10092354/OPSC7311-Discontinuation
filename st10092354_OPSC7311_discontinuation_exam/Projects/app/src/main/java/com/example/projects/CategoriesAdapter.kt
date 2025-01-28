package com.example.projects

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(private var Data: List<Data>, context:Context):
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false )
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = Data.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val data = Data[position]
        holder.titleTextView.text = data.title
        holder.contentTextView.text = data.content
    }

    fun refreshData(newCategories: List<Data>){
        Data = newCategories
        notifyDataSetChanged()
    }
}