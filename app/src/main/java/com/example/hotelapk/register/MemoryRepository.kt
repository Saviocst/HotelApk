package com.example.hotelapk.register

object MemoryRepository : HotelRepository {
    private var nextId = 1L
    private val hotelList = mutableListOf<Hotel>()

    init {
        save(Hotel(0, "Lamour Hotel", "Rua Gado Brabo", 5.0f))
        save(Hotel(0, "Atecubanos Hotel", "Rua Meneses Figueredo", 4.0f))
        save(Hotel(0, "Hotel Gado", "Av. Chora Papai", 3.0f))
        save(Hotel(0, "Hotel Só Prazer", "Rua João Amaro", 5.0f))
        save(Hotel(0, "Chora na Minha Hotel", "Rua Fode Fode", 4.5f))
    }



    override fun save(hotel: Hotel) {

        if (hotel.id == 0L){
            hotel.id = nextId++
            hotelList.add(hotel)

        } else {

            val index = hotelList.indexOfFirst { it.id == hotel.id }

            if (index > -1){
                hotelList[index] = hotel
            } else{
                hotelList.add(hotel)
            }
        }
    }

    override fun remove(vararg hotels: Hotel) {
        hotelList.removeAll(hotels)
    }

    override fun hotelById(id: Long, callback: (Hotel?) -> Unit) {
        callback(hotelList.find { it.id == id })
    }

    override fun search(term: String, callback: (List<Hotel>) -> Unit) {
        callback(
            if (term.isEmpty()) hotelList else hotelList.filter {
                it.name.toUpperCase().contains(term.toUpperCase())
            }
        )
    }

}