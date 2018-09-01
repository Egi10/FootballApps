package com.footballapps.egifcb.footballapps

import id.co.egifcb.aplikasifootballmatchschedule.until.CoroutineContextProvider
import kotlinx.coroutines.experimental.Unconfined
import kotlin.coroutines.experimental.CoroutineContext

class TestContextProvider : CoroutineContextProvider() {
    override val main: CoroutineContext = Unconfined
}