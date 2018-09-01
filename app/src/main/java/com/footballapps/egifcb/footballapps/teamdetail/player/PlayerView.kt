package com.footballapps.egifcb.footballapps.teamdetail.player

import com.footballapps.egifcb.footballapps.model.Player

interface PlayerView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Player>)
}