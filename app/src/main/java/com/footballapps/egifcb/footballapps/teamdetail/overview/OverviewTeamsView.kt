package com.footballapps.egifcb.footballapps.teamdetail.overview

import com.footballapps.egifcb.footballapps.model.Teams

interface OverviewTeamsView {
    fun showLoading()
    fun hideLoading()
    fun showOverview(data: List<Teams>)
}