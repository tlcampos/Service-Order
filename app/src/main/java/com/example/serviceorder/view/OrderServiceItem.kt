package com.example.serviceorder.view

import android.view.View
import android.widget.TextView
import com.example.serviceorder.R
import com.example.serviceorder.model.OrderService
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class OrderServiceItem(private val orderService: OrderService) : Item<OrderServiceItem.OrderServiceViewHolder>() {

    class OrderServiceViewHolder(view: View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View) = OrderServiceViewHolder(itemView)

    override fun bind(viewHolder: OrderServiceViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.order_id).text = orderService.orderID
        viewHolder.itemView.findViewById<TextView>(R.id.order_data_open).text = orderService.orderDateStart
        //viewHolder.itemView.findViewById<TextView>(R.id.order_device).text = orderService.orderDevice
        viewHolder.itemView.findViewById<TextView>(R.id.order_resume).text = orderService.orderResume
    }

    override fun getLayout() = R.layout.order_service_item
}
