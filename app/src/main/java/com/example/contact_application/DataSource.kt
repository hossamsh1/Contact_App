package com.example.contact_app

import com.example.contact_application.R

class DataSource {

    fun getDataItems():List<Data>{
        val dataCall= mutableListOf<Data>()

        dataCall.add(
            Data(
                R.string.name_My_frind2,
                R.string.num_DAD
                ,R.drawable.granny
            )
        )

        dataCall.add(
            Data(
                R.string.name_My_frind
                ,R.string.num_hossam
                ,R.drawable.brother)
        )

        dataCall.add(
            Data(
                R.string.name_My_frind3,
                R.string.num_younis
                ,R.drawable.sister
            )
        )

        dataCall.add(
            Data(
                R.string.name_My_frind2,
                R.string.num_younis
                ,R.drawable.grandfather
            )
        )

        dataCall.add(
            Data(
                R.string.name_My_frind2,
                R.string.num_younis
                ,R.drawable.daughter
            )
        )

        dataCall.add(
            Data(
                R.string.name_My_frind3,
                R.string.num_ahmed_Bahgat
                ,R.drawable.friend_1
            )
        )

        return dataCall

    }
}