package ie.wit.donationx.activities


import android.app.Application
import ie.wit.donationx.models.ReviewerMemStore
import ie.wit.donationx.models.ReviewerStore

import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var reviews: ReviewerStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        reviews = ReviewerMemStore()
        i("Reviewer started")
    }
}