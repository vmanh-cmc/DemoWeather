package com.example.demoweather.ui.search

import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RxSearchObservable {
    companion object {
        fun fromView(searchView: TextInputEditText): Observable<String> {
            val subject = PublishSubject.create<String>()
            searchView.setOnEditorActionListener(TextView.OnEditorActionListener { p0, p1, p2 ->
                subject.onComplete()
                return@OnEditorActionListener false
            })
            searchView.addTextChangedListener {
                subject.onNext(it?.toString() ?: "")
            }
            return subject
        }
    }
}