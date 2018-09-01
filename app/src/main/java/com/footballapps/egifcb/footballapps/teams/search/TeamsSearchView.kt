package com.footballapps.egifcb.footballapps.teams.search

import com.footballapps.egifcb.footballapps.model.Teams

interface TeamsSearchView {
    fun showLoadingSearch()
    fun hideLoadingSearch()
    fun showEventListSearch(data: List<Teams>)
}