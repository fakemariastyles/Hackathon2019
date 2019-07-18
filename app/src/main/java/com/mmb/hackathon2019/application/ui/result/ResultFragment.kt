package com.mmb.hackathon2019.application.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mmb.hackathon2019.R
import com.mmb.hackathon2019.application.HackathonApp
import com.mmb.hackathon2019.data.entity.ResultEntity
import javax.inject.Inject

class ResultFragment : Fragment() {
    private var serial: String? = null
    @Inject
    lateinit var viewModel: ResultViewModel
    var result: ResultEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HackathonApp.component.inject(this)
        serial = arguments?.getString(KEY_SERIAL)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        serial?.let {
            viewModel.getResult(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etCardIdTV = view.findViewById<TextView>(R.id.et_card_id)
        val messageDetailTV =  view.findViewById<TextView>(R.id.message_detail)
        val remainAmountTV =  view.findViewById<TextView>(R.id.remain_amount)
        viewModel.apply {
            result.observe(this@ResultFragment, androidx.lifecycle.Observer {
                remainAmountTV.text = it.remainAmount.toString()
                etCardIdTV.text = it.etCardId.toString()
                messageDetailTV.text = it.messageDetail.toString()
//                remainAmountTV.text = "1000"
//                etCardIdTV.text = "12"
//                messageDetailTV.text = "no message found"
            })

        }
    }

    companion object {
        fun newInstance(slug: String?): ResultFragment {
            return ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_SERIAL, slug)
                }
            }
        }
        private const val KEY_SERIAL = "SERIAL"
    }
}