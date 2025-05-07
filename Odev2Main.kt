package com.furkansafran.kotlindersleri.Odev2

fun main() {
    val f = Odev2()
    val donusenSonuc = f.celcuisToFahrenheit(32.5)
    println("Fahrenheit : $donusenSonuc F")

    f.cevreHesaplama(10,20)

    val faktoriyel = f.faktoriyelHesaplama(5)
    println(faktoriyel)

    val taneAVar = f.kacTaneAVar("Kasim Adalan")
    println("$taneAVar tane a vardir")

    val icAcilarToplam = f.icAcilarToplami(5)
    println("Ic acilar toplami : $icAcilarToplam")

    val maas = f.maasHesabi(21)
    println("Maas : $maas")

    val kotaFiyat = f.kotaFiyat(51)
    println("kota fiyati : $kotaFiyat")
}