package com.footballapps.egifcb.footballapps.teams

import com.footballapps.egifcb.footballapps.model.Teams

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Teams>)
}