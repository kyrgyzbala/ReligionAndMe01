package com.example.religionandme01.fragments.ask

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.religionandme01.R
import kotlinx.android.synthetic.main.fragment_question.*


class QuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        askQuestion.setOnClickListener {
            val intent = Intent(this.requireContext(), AskQuestionActivity::class.java)
            startActivity(intent)
        }
    }
}