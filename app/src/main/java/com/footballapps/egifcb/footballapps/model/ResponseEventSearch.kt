package com.footballapps.egifcb.footballapps.model

import com.google.gson.annotations.SerializedName

class ResponseEventSearch(
        @SerializedName("event")
        val event: List<Event>)