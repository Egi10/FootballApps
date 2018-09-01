package com.footballapps.egifcb.footballapps.event.last

import com.footballapps.egifcb.footballapps.model.Event

interface LastEventView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}