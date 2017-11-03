package com.sladkin.vidmeapp.presentation

interface Presenter<T>{

    fun setView(view: T)

    fun destroy()
}
