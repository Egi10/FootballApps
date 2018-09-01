package id.co.egifcb.aplikasifootballmatchschedule.detailevent

import com.footballapps.egifcb.footballapps.model.Teams

interface DetailEventView {
    fun showLoading()
    fun hideLoading()
    fun showTeamHome(data: List<Teams>)
    fun showTeamAway(data: List<Teams>)
}