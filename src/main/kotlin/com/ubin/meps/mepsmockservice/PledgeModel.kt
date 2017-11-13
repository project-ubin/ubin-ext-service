package com.ubin.meps.mepsmockservice

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.nio.channels.spi.AbstractInterruptibleChannel
import kotlin.properties.Delegates

@JsonInclude(JsonInclude.Include.NON_NULL)
class PledgeModel{

    var receiver: String? = null
    var transactionAmount: Double? = null
    var channel : String? = null

    constructor(){}
    
    constructor(receiver: String, transactionAmount: Double){
        this.receiver = receiver
        this.transactionAmount = transactionAmount
    }

    constructor(receiver: String, transactionAmount: Double, channel: String){
        this.receiver = receiver
        this.transactionAmount = transactionAmount
        this.channel = channel
    }
}