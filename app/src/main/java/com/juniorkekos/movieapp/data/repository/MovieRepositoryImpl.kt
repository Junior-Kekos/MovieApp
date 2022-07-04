package com.juniorkekos.movieapp.data.repository

import com.juniorkekos.movieapp.data.remote.MovieApi
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MovieRepositoryImpl @Inject constructor(private val api: MovieApi)