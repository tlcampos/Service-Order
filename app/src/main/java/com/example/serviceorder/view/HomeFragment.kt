package com.example.serviceorder.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serviceorder.R
import com.example.serviceorder.data.OrderServiceDataSource
import com.example.serviceorder.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private lateinit var presenter: HomePresenter
    private val adapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = HomePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        presenter.findAllOrderService()

        recyclerView.adapter = adapter
    }

    fun showOrders(orders: List<OrderServiceItem>) {
        adapter.addAll(orders)
        adapter.notifyDataSetChanged()

    }
    fun showFailure(message: String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
    fun showProgress(){
        progressBar.visibility = View.VISIBLE
    }
    fun hideProgress(){
        progressBar.visibility = View.GONE
    }
}