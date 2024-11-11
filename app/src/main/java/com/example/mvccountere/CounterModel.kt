package com.example.mvccountere

class CounterModel {
    private var count: Int = 0

    //Method to increae the count
    fun increament() {
        count++
    }

    fun reset() {
        count = 0
    }

    fun getCount(): Int {
        return count
    }
}