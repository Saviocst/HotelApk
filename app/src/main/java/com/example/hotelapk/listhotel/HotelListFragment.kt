package com.example.hotelapk.listhotel

import android.R
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import com.example.hotelapk.register.Hotel
import com.example.hotelapk.register.MemoryRepository

class HotelListFragment : ListFragment(), HotelListView {
    private val presenter = HotelListPresenter(this, MemoryRepository)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.searchHotels("")
    }

    override fun showHotels(hotel: List<Hotel>) {
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, hotel)
        listAdapter = adapter
    }

    // Dessa parte para baixo foi implementada depois

    override fun showHotelDetails(hotel: Hotel) {
        if( activity is OnHotelClickListener){
            val listener = activity as OnHotelClickListener
            listener.onHotelClick(hotel)
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val hotel = l.getItemAtPosition(position) as Hotel
        presenter.showHotelDetails(hotel)

    }

    interface OnHotelClickListener{
        fun onHotelClick(hotel: Hotel)
    }
}