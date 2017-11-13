package com.ubin.meps.mepsmockservice

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.omg.CORBA.portable.Delegate
import kotlin.properties.Delegates

@JsonInclude(JsonInclude.Include.NON_NULL)
class RedeemModel {
    var sender: String? = null
    var transactionAmount: Double? = null
    var channel : String? = null

    constructor(){}

    constructor(sender: String, transactionAmount: Double){
        this.sender = sender
        this.transactionAmount = transactionAmount;
    }

    constructor(sender: String, transactionAmount: Double, channel: String){
        this.sender = sender
        this.transactionAmount = transactionAmount
        this.channel = channel
    }
}