package com.example.serviceorder.data

import android.util.Log
import com.example.serviceorder.model.OrderService
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class OrderServiceDataSource {

    private lateinit var dbRef: DatabaseReference
    private lateinit var response: ArrayList<OrderService>

    fun findAllOrders(callback: ListOrderCallback) {

        dbRef = FirebaseDatabase.getInstance().getReference("order")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
  //              response.clear()
                if (snapshot.exists()) {
                    for (orderSnap in snapshot.children) {
                        val order = orderSnap.getValue(OrderService::class.java)
                        response.add(order!!)
                        Log.d("Response", "ordem +$response")
                    }
                    callback.onSuccess(response)
                }
                callback.onComplete()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("Error", "loadPost:onCancelled", databaseError.toException())
            }
        })

    }
}

