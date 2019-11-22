package com.deams.ynovmydiet

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_image_fragment.*
import kotlinx.android.synthetic.main.layout_image_fragment.view.*


class ImageFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.layout_image_fragment,container,false)

        // Get the text view widget reference from custom layout
        val tv = view.findViewById<Button>(R.id.changerMdp)
        val nMdp = view.findViewById<EditText>(R.id.newMdp)

        // Return the fragment view/layout
        view.changerMdp.setOnClickListener {
                this.newMdp.visibility = View.VISIBLE
        }
        return view
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}