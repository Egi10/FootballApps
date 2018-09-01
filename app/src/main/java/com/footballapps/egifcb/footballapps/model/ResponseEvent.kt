package com.footballapps.egifcb.footballapps.model

import com.google.gson.annotations.SerializedName

data class ResponseEvent(
        @SerializedName("events")
        val events: List<Event>)