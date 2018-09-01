package id.co.egifcb.aplikasifootballmatchschedule.detailevent

import com.footballapps.egifcb.footballapps.api.ApiRepository
import com.footballapps.egifcb.footballapps.api.TheSportDBApi
import com.footballapps.egifcb.footballapps.model.ResponseTeam
import com.google.gson.Gson
import id.co.egifcb.aplikasifootballmatchschedule.until.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class DetailEventPresenter(private val view: DetailEventView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson,
                           private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamHome(team: String?) {
        view.showLoading()

        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getDetailEvent(team)),
                        ResponseTeam::class.java)
            }
            view.showTeamHome(data.await().teams)
            view.hideLoading()
        }
    }

    fun getTeamAway(team: String?) {
        view.showLoading()

        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(TheSportDBApi.getDetailEvent(team)),
                        ResponseTeam::class.java)
            }
            view.showTeamAway(data.await().teams)
            view.hideLoading()
        }
    }
}