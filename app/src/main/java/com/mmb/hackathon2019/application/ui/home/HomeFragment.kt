package com.mmb.hackathon2019.application.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mmb.hackathon2019.R
import com.mmb.hackathon2019.application.ui.amount.AmountFragment

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.get_amount_action)
            .setOnClickListener {
                fragmentManager?.beginTransaction()
                    ?.replace(R.id.content_frame, AmountFragment())
                    ?.addToBackStack(null)
                    ?.commit()
            }
    }
}