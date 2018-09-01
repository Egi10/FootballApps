package com.footballapps.egifcb.footballapps.event.next

import com.footballapps.egifcb.footballapps.model.Event

interface NextEventView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}