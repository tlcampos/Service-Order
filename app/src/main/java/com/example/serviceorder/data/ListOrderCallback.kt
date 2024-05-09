package com.example.serviceorder.data

import com.example.serviceorder.model.OrderService

interface ListOrderCallback {

    fun onSuccess(response: ArrayList<OrderService>)

    fun onError(response: String)

    fun onComplete()
}