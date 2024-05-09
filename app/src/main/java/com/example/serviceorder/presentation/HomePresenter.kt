package com.example.serviceorder.presentation

import com.example.serviceorder.data.ListOrderCallback
import com.example.serviceorder.data.OrderServiceDataSource
import com.example.serviceorder.model.OrderService
import com.example.serviceorder.view.HomeFragment
import com.example.serviceorder.view.OrderServiceItem


class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: OrderServiceDataSource) : ListOrderCallback {

    fun findAllOrderService() {
        view.showProgress()
        dataSource.findAllOrders(this)
    }

    override fun onSuccess(response: ArrayList<OrderService>) {
        val orders = response.map { OrderServiceItem(it) }

        view.showOrders(orders)
    }

    override fun onComplete() {
        view.hideProgress()
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

}