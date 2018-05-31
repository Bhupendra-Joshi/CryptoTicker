package com.crypto.bhupendra.cryptoticker.network.models

import com.squareup.moshi.Json

data class Response(

        @Json(name = "BTC")
        var BTC: String? = null,

        @Json(name = "ETH")
        var ETH: String? = null,

        @Json(name = "BCH")
        var BCH: String? = null,

        @Json(name = "XRP")
        var XRP: String? = null,

        @Json(name = "LTC")
        var LTC: String? = null,

        @Json(name = "MIOTA")
        var MIOTA: String? = null,

        @Json(name = "OMG")
        var OMG: String? = null,

        @Json(name = "GNT")
        var GNT: String? = null
)