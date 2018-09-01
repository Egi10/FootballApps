package com.footballapps.egifcb.footballapps.event.next

import com.footballapps.egifcb.footballapps.TestContextProvider
import com.footballapps.egifcb.footballapps.api.ApiRepository
import com.footballapps.egifcb.footballapps.api.TheSportDBApi
import com.footballapps.egifcb.footballapps.model.Event
import com.footballapps.egifcb.footballapps.model.ResponseEvent
import com.google.gson.Gson
import id.co.egifcb.aplikasifootballmatchschedule.nextevent.NextEventPresenter
import id.co.egifcb.aplikasifootballmatchschedule.nextevent.NextEventView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class NextPresenterTest {
    private lateinit var presenter: NextEventPresenter
    @Mock
    private lateinit var view: NextEventView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextEventPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetEventList() {
        val event: MutableList<Event> = mutableListOf()
        val response = ResponseEvent(event)
        val league = "4328"

        `when`(gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextEvent(league)),
                ResponseEvent::class.java)).thenReturn(response)

        presenter.getEventList(league)

        verify(view).showLoading()
        verify(view).showEventList(event)
        verify(view).hideLoading()
    }
}