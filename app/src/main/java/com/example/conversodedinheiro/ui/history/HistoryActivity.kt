package com.example.conversodedinheiro.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.conversodedinheiro.core.extensions.createDialog
import com.example.conversodedinheiro.core.extensions.createProgressDialog
import com.example.conversodedinheiro.databinding.ActivityHistoryBinding
import com.example.conversodedinheiro.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


    class HistoryActivity : AppCompatActivity() {

        private val adapter by lazy { HistoryListAdapter() }
        private val dialog by lazy { createProgressDialog() }
        private val viewModel by viewModel<HistoryViewModel>()
        private val binding by lazy { ActivityHistoryBinding.inflate(layoutInflater) }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)

            binding.rvHistory.adapter = adapter
            binding.rvHistory.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
            )

            setSupportActionBar(binding.toolbar)


            bindObserve()

            lifecycle.addObserver(viewModel)
        }

        private fun bindObserve() {
            viewModel.state.observe(this) {
                when (it) {
                    HistoryViewModel.State.Loading -> dialog.show()
                    is HistoryViewModel.State.Error -> {
                        dialog.dismiss()
                        createDialog {
                            setMessage(it.error.message)
                        }.show()
                    }
                    is HistoryViewModel.State.Success -> {
                        dialog.dismiss()
                        adapter.submitList(it.list)
                    }
                }
            }
        }

    }