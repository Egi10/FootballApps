package com.footballapps.egifcb.footballapps.team

import com.footballapps.egifcb.footballapps.TestContextProvider
import com.footballapps.egifcb.footballapps.api.ApiRepository
import com.footballapps.egifcb.footballapps.api.TheSportDBApi
import com.footballapps.egifcb.footballapps.model.Event
import com.footballapps.egifcb.footballapps.model.ResponseEvent
import com.footballapps.egifcb.footballapps.model.ResponseTeam
import com.footballapps.egifcb.footballapps.model.Teams
import com.footballapps.egifcb.footballapps.teams.TeamsPresenter
import com.footballapps.egifcb.footballapps.teams.TeamsView
import com.google.gson.Gson
import id.co.egifcb.aplikasifootballmatchschedule.nextevent.NextEventPresenter
import id.co.egifcb.aplikasifootballmatchschedule.nextevent.NextEventView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TeamsPresenterTest {
    private lateinit var presenter: TeamsPresenter
    @Mock
    private lateinit var view: TeamsView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetEventList() {
        val teams: MutableList<Teams> = mutableListOf()
        val response = ResponseTeam(teams)
        val league = "English Premier League"

        `when`(gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeams(league)),
                ResponseTeam::class.java)).thenReturn(response)

        presenter.getEventList(league)

        verify(view).showLoading()
        verify(view).showEventList(teams)
        verify(view).hideLoading()
    }
}