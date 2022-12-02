package com.example.book.domain.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.book.R
import com.example.book.domain.models.IntentBook
import com.example.book.domain.models.Item
import com.example.book.presentation.DetailsBook
import kotlinx.android.synthetic.main.item_book.view.*

class BooksListAdapter: RecyclerView.Adapter<BooksListAdapter.BooksListViewHolder>() {
    private var listBooks = emptyList<Item>()
    private val DEFAULT = "Информация отсутствует"

    class BooksListViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksListAdapter.BooksListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent, false)
        return BooksListViewHolder(view)
    }
    override fun onBindViewHolder(holder: BooksListAdapter.BooksListViewHolder, position: Int) {
        holder.itemView.tvTitle.text = listBooks[position].volumeInfo.title
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsBook::class.java)
            intent.putExtra("bookInfo", IntentBook( listBooks[position].volumeInfo.imageLinks.thumbnail,  listBooks[position].volumeInfo.title, listBooks[position].volumeInfo!!.subTitle?: DEFAULT, listBooks[position].volumeInfo!!.authors[0]?: DEFAULT, listBooks[position].volumeInfo.publishedDate))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listBooks.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Item>){
        listBooks = list
        notifyDataSetChanged()
    }

}