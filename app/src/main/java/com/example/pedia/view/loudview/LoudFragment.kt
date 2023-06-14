package com.example.pedia.view.loudview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pedia.R
import java.util.*

class LoudFragment : Fragment() {
    private lateinit var loudTextView: TextView
    private val callBackQueue: Queue<String> = LinkedList(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_loud, container, false)
        callBackQueue.offer("onCreateView")
        bindView(view)
        setUpListeners()
        return view
    }

    private fun bindView(view: View) {
        loudTextView = view.findViewById(R.id.loudTV)
    }

    private fun setUpListeners() {
        loudTextView.setOnClickListener {
            debug()
        }
    }

    //   Otherwise Unused Overrides
    override fun onAttach(context: Context) {
        super.onAttach(context)
        callBackQueue.offer("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callBackQueue.offer("onCreate")
    }


    override fun onStart() {
        super.onStart()
        callBackQueue.offer("onStart")
    }

    override fun onResume() {
        super.onResume()
        callBackQueue.offer("onResume")
    }

    override fun onPause() {
        super.onPause()
        callBackQueue.offer("onPause")
    }

    override fun onStop() {
        super.onStop()
        callBackQueue.offer("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        callBackQueue.offer("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        callBackQueue.offer("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        callBackQueue.offer("onDetach")
        debug()
    }

    private fun debug() {
        println("Debug Process")
    }
}
