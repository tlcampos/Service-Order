package com.example.serviceorder.data

import android.os.Handler
import android.os.Looper
import com.example.serviceorder.model.OrderService

class OrderServiceDataSource {

    fun findAllOrders(callback: ListOrderCallback){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                OrderService(
                    "OS2024000001",
                    "26/abril",
                    "Smartphone",
                    "O celular não carrega após queda, Necessita a troca"
                ),
                OrderService(
                    "OS2024000002",
                    "26/abril",
                    "Smartphone",
                    "O celular não carrega após queda, Necessita a troca"
                ),
                OrderService(
                    "OS2024000003",
                    "27/abril",
                    "Smartphone",
                    "O celular não carrega após queda, Necessita a troca"
                ),
                OrderService(
                    "OS2024000004",
                    "28/abril",
                    "Smartphone",
                    "O celular não carrega após queda, Necessita a troca"
                ),
                OrderService(
                    "OS2024000005",
                    "30/abril",
                    "Smartphone",
                    "O celular não carrega após queda, Necessita a troca"
                )
            )
            //Lista Pronta(response)

            //onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE!")

            callback.onSuccess(response)

            callback.onComplete()
        },2000)
    }
}