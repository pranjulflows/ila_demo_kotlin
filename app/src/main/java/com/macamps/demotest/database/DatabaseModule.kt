package com.macamps.demotest.database

import com.macamps.demotest.R
import com.macamps.demotest.model.DataModel

object DatabaseModule {
    var imageResList =
        arrayListOf(
            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3,
            R.drawable.slide4,
            R.drawable.slide5,
            R.drawable.slide6,
            R.drawable.slide7,
            R.drawable.slide8,
        )

    fun getMoviesList(): ArrayList<DataModel> {
        val list = arrayListOf<DataModel>()

        list.add(
            DataModel(
                labelText = "No Time To Die",
                description = "James Bond has left active service. His peace is short-lived when Felix Leiter, an old friend from the CIA, turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
                imageUrl = R.drawable.no_time_to_die
            )
        )
        list.add(
            DataModel(
                labelText = "The Flash",
                description = "Barry Allen uses his super speed to change the past, but his attempt to save his family creates a world without super heroes, forcing him to race for his life in order to save the future.",
                imageUrl = R.drawable.the_flash
            )
        )
        list.add(
            DataModel(
                labelText = "Insidious: The Red Door",
                description = "The Lamberts 10 years after the last installment, as Dalton begins college",
                imageUrl = R.drawable.insidious
            )
        )
        list.add(
            DataModel(
                labelText = "Greatest Days",
                description = "A feature adaptation of the 'The Band' musical, featuring the songs of Take That.",
                imageUrl = R.drawable.greatest_day
            )
        )
        list.add(
            DataModel(
                labelText = "The Godfather",
                description = "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.",
                imageUrl = R.drawable.godfather
            )
        )
        list.add(
            DataModel(
                labelText = "Mission: Impossible - Dead Reckoning Part One",
                description = "Ethan Hunt and his IMF team must track down a dangerous weapon before it falls into the wrong hands.",
                imageUrl = R.drawable.mission_imp
            )
        )
        list.add(
            DataModel(
                labelText = "Guardians of the Galaxy Vol. 3",
                description = "Still reeling from the loss of Gamora, Peter Quill rallies his team to defend the universe and one of their own - a mission that could mean the end of the Guardians if not successful.",
                imageUrl = R.drawable.gog
            )
        )
        list.add(
            DataModel(
                labelText = "Barbie",
                description = "To live in Barbie Land is to be a perfect being in a perfect place. Unless you have a full-on existential crisis. Or you're a Ken.",
                imageUrl = R.drawable.barbie
            )
        )
        list.add(
            DataModel(
                labelText = "Oppenheimer",
                description = "The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb.",
                imageUrl = R.drawable.open
            )
        )
        return list
    }
}