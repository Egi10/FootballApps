package com.footballapps.egifcb.footballapps.teamdetail.player

import com.footballapps.egifcb.footballapps.api.ApiRepository
import com.footballapps.egifcb.footballapps.api.TheSportDBApi
import com.footballapps.egifcb.footballapps.model.ResponsePlayer
import com.google.gson.Gson
import id.co.egifcb.aplikasifootballmatchschedule.until.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class PlayerPresenter(private val view: PlayerView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson,
                      private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getPlayer(idTeam: String?) {
        view.showLoading()

        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getPlayer(idTeam)),
                        ResponsePlayer::class.java)
            }
            view.showEventList(data.await().player)
            view.hideLoading()
        }
    }
}