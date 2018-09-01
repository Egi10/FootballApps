package com.footballapps.egifcb.footballapps.model

import com.google.gson.annotations.SerializedName

class ResponsePlayer(
        @SerializedName("player")
        val player: List<Player>)