package com.footballapps.egifcb.footballapps.event.last

import com.footballapps.egifcb.footballapps.api.ApiRepository
import com.footballapps.egifcb.footballapps.api.TheSportDBApi
import com.footballapps.egifcb.footballapps.model.ResponseEvent
import com.footballapps.egifcb.footballapps.until.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class LastEventPresenter(private val view: LastEventView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson,
                         private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getEventList(league: String?) {
        view.showLoading()

        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLastEvent(league)),
                        ResponseEvent::class.java)
            }
            view.showEventList(data.await().events)
            view.hideLoading()
        }
    }
}