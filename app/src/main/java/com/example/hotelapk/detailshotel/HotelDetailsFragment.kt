package com.example.hotelapk.detailshotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hotelapk.R
import com.example.hotelapk.register.Hotel
import com.example.hotelapk.register.MemoryRepository
import kotlinx.android.synthetic.main.fragment_hotel_details.*

class HotelDetailsFragment : Fragment(), HotelDetailsView {
    private val presenter = HotelDetailsPresenter(this, MemoryRepository)
    private var hotel: Hotel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hotel_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadHotelDetails(arguments?.getLong(EXTRA_HOTEL_ID, -1) ?: -1)
    }

    override fun showHotelsDetails(hotel: Hotel) {
        this.hotel = hotel

        text_name.text = hotel.name
        text_address.text = hotel.address
        rbt_rating_bar.rating = hotel.rating

    }

    override fun errorHotelNotFound() {
        text_name.text = getString(R.string.error_hotel_not_found)
        text_address.visibility = View.GONE
        rbt_rating_bar.visibility = View.GONE

    }

    companion object{

        const val TAG_DETAILS = "tagDetalhe"
        private const val EXTRA_HOTEL_ID = "hotelId"

        fun newInstance( id: Long) = HotelDetailsFragment().apply {
            arguments = Bundle().apply {
                putLong(EXTRA_HOTEL_ID, id)
            }
        }
    }
}