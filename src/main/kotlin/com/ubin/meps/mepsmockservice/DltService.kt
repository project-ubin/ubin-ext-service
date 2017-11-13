package com.ubin.meps.mepsmockservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DltService {

    @Value("\${PledgeURI}")
    var pledgeURI: String? =null;

    @Value("\${RedeemURI}")
    var redeemURI : String? =null;

    @Value("\${Dlt}")
    var dlt : String? = null;

    fun poke(): String {
        return "The endpoint in properties is "+ pledgeURI
    }

    fun poke(value: PledgeModel): String {
        return "Hello ${value.receiver}, you pledged an amount of ${value.transactionAmount}"
    }

    fun pledgeToDlt(value: PledgeModel) : Map<*,*> {
        val rest = RestTemplate()
        return  rest.postForObject(pledgeURI, value, Map::class.java)
    }

    fun redeemToDlt(value: RedeemModel) : Map<*,*> {


        println("Redeem to ${dlt}")

        var map = mutableMapOf<String, String>()

        if(dlt.equals("Corda")) {
            map.put("dlt", dlt!!);
            return map;
        }
        val rest = RestTemplate()
        return  rest.postForObject(redeemURI, value, Map::class.java)
    }

}