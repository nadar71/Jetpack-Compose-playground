package it.mapo.indie.mvvm_with_compose_sample_01.util

import java.util.*


object  GeneralUtility{
    // list of currency code as string soprted ascending order
    fun getAllCurrencies(): List<String> {
        val currencySet = Currency.getAvailableCurrencies() // : Set<Currency?>?
        val sortedCurrencySet = currencySet.toSortedSet(compareBy { it.currencyCode })
        return sortedCurrencySet.toList().map { it.toString() }
    }

    /*fun getAllCurrencies(): List<String> {
        val currencySet =  Currency.getAvailableCurrencies() // : Set<Currency?>?
        val currencyList = currencySet.toList().map{it.toString()}
        return currencyList.toSortedSet().toList()
    }*/


    // adding 2 decimals writing from left to right after 3 integer
    fun numberInputDecimalSeparators(input: String?): String {
        var localInput = input
        var result = ""
        var float_section = ""

        if (localInput == null) localInput = ""

        var temp = localInput.trim { it <= ' ' }
        temp = temp.replace(",", "")
        temp = temp.replace(" ", "")

        val input_array = temp.split(".")
        val decimal_section = input_array[0]

        if (input_array.size > 1)
            float_section = input_array[1]

        if (decimal_section.length > 3) {
            var num = 0
            for (i in decimal_section.length downTo 1) {
                if (num == 3) {
                    num = 0
                    result = ",$result"
                }
                num++
                result = decimal_section.substring(i - 1, i) + result
            }
            if (float_section != "")
                result = "$result.$float_section"
        } else {
            result = decimal_section.replace(",", "")
            if (float_section != "")
                result = "$result.$float_section"
        }
        return result
    }


    fun filterNumberInput(input: String?): String {
        var localInput = input
        var result = ""
        var float_section = ""

        if (localInput == null) localInput = ""

        result = localInput.trim { it <= ' ' }
        result = result.replace(".", ",")
        result = result.replace(" ", "")

        return result
    }
    
    
    fun idGeneration(): String{
        return UUID.randomUUID().toString()
    }



}