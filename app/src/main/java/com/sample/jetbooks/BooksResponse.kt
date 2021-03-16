package com.sample.jetbooks

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

sealed class BooksResponse
data class OnSuccess(val querySnapshot: QuerySnapshot?): BooksResponse()
data class OnError(val exception: FirebaseFirestoreException?): BooksResponse()