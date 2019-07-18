package com.mmb.hackathon2019.application.ui.amount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.mmb.hackathon2019.R
import com.mmb.hackathon2019.application.ui.result.ResultFragment

class AmountFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_amount_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.get_amount)
        val serialET = view.findViewById<EditText>(R.id.serial)

        button.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.content_frame, ResultFragment.newInstance(serialET.text.toString()))
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}