package ie.wit.donationx.main

import android.app.Application
import ie.wit.donationx.models.ReviewerMemStore
import ie.wit.donationx.models.ReviewerStore
import timber.log.Timber

/*
class DonationXApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("Starting DonationX Application")
    }
}*/
class ReviewerXApp : Application() {

    lateinit var reviewersStore: ReviewerStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        reviewersStore = ReviewerMemStore()
        Timber.i("DonationX Application Started")
    }
}
