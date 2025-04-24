package com.furkansafran.kotlindersleri.Odev2

class Odev2 {
    fun celcuisToFahrenheit(celcius: Double): Double {
        return ((celcius*1.8) + 32)
    }
    fun cevreHesaplama(kenar1 :Int,kenar2 : Int){
        val cevre = 2*(kenar1+kenar2)
        println("Cevre : $cevre")

    }
    fun faktoriyelHesaplama(sayi: Int): Int {
        var toplam = 1
        for (i in 1 .. sayi) {
         toplam = i * toplam
        }
        return toplam
    }
    fun kacTaneAVar(kelime: String): Int {

        var taneVar = 0
        for (i in kelime){
            if(i =='a' || i =='A'){
             taneVar++
            }
        }
        return taneVar
    }
    fun icAcilarToplami(kenar: Int): Int {
        return (kenar-2)*180
    }
    fun maasHesabi(gunSayisi: Int): Int {
        val calistigiSaat = gunSayisi * 8
        var maas = 0
        if (calistigiSaat > 160) {
            val calistigiSaatUcreti = 160 * 10
            val mesaiSaat = calistigiSaat - 160
            val mesaiUcreti = mesaiSaat * 20
             maas = calistigiSaatUcreti + mesaiUcreti
        }else{
             maas = calistigiSaat * 10
        }
        return maas
    }
    fun kotaFiyat(kota: Int): Int {
        var fiyat = 0
        if (kota <= 50) {
            fiyat = 100
        }else{
            fiyat = 100 + ((kota - 50) * 4)
        }
        return fiyat
    }
}



