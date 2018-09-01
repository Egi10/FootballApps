package com.footballapps.egifcb.footballapps.model

import com.google.gson.annotations.SerializedName

class ResponseTeam(
        @SerializedName("teams")
        val teams: List<Teams>)