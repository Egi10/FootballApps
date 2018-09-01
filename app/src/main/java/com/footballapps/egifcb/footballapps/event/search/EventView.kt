package com.footballapps.egifcb.footballapps.event.search

import com.footballapps.egifcb.footballapps.model.Event

interface EventView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}