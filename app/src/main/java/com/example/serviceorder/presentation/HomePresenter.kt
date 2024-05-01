package com.example.serviceorder.presentation

import android.os.Handler
import android.os.Looper
import com.example.serviceorder.model.OrderService
import com.example.serviceorder.view.HomeFragment
import com.example.serviceorder.view.OrderServiceItem


class HomePresenter(private val view: HomeFragment) {

    fun findAllOrderService() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<OrderService>){
        val orders =  response.map {  OrderServiceItem(it) }

        view.showOrders(orders)
    }

    fun onComplete(){
        view.hideProgress()
    }
    fun onError(message: String){
        view.showFailure(message)
    }

    private fun fakeRequest() {
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

            onSuccess(response)

            onComplete()
        },2000)
    }
}