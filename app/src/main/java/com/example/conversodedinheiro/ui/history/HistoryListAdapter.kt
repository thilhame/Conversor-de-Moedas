package com.example.conversodedinheiro.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.conversodedinheiro.core.extensions.formatCurrency
import com.example.conversodedinheiro.data.model.Coin
import com.example.conversodedinheiro.data.model.WelcomeValue
import com.example.conversodedinheiro.databinding.ItemHistoryBinding

class HistoryListAdapter : ListAdapter<WelcomeValue, HistoryListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WelcomeValue) {
            binding.tvName.text = item.name

            val coin = Coin.getByName(item.codein)
            binding.tvValue.text = item.bid.formatCurrency(coin.locale)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<WelcomeValue>() {
    override fun areItemsTheSame(oldItem: WelcomeValue, newItem: WelcomeValue) = oldItem == newItem
    override fun areContentsTheSame(oldItem: WelcomeValue, newItem: WelcomeValue) = oldItem.id == newItem.id
}