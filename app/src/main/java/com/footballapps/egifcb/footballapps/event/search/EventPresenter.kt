package com.footballapps.egifcb.footballapps.event.search

import com.footballapps.egifcb.footballapps.api.ApiRepository
import com.footballapps.egifcb.footballapps.api.TheSportDBApi
import com.footballapps.egifcb.footballapps.model.ResponseEventSearch
import com.google.gson.Gson
import id.co.egifcb.aplikasifootballmatchschedule.until.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class EventPresenter(private val view: EventView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson,
                     private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getEventList(teams: String?) {
        view.showLoading()

        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getEventSearch(teams)),
                        ResponseEventSearch::class.java)
            }
            view.showEventList(data.await().event)
            view.hideLoading()
        }
    }
}