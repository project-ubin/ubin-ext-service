package com.ubin.meps.mepsmockservice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import javax.xml.ws.Response


@RestController
@EnableWebMvc
@CrossOrigin
@RequestMapping("meps")
class MepsController(val dltService: DltService){


    @CrossOrigin
    @PostMapping("/pledge")
    fun createPledge(@RequestBody value: PledgeModel) : ResponseEntity<Map<*,*>> {
        val response = dltService.pledgeToDlt(value)
        val result = ResponseEntity<Map<*,*>>(response, HttpStatus.CREATED)
        return result
    }

    @PostMapping("/redeem")
    fun approveRedeem(@RequestBody value: RedeemModel) : ResponseEntity<Map<*,*>>{
        val response = dltService.redeemToDlt(value);
        val result = ResponseEntity<Map<*,*>>(response, HttpStatus.CREATED)
        return result
    }

}
