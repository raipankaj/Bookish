package com.sample.jetbooks.repo

import com.google.firebase.firestore.FirebaseFirestore
import com.sample.jetbooks.OnError
import com.sample.jetbooks.OnSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class BooksRepo {

    private val firestore = FirebaseFirestore.getInstance()

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getBookDetails() = callbackFlow {

        val collection = firestore.collection("books")
        val snapshotListener = collection.addSnapshotListener { value, error ->
            val response = if (error == null) {
                OnSuccess(value)
            } else {
                OnError(error)
            }

            offer(response)
        }

        awaitClose {
            snapshotListener.remove()
        }
    }
}