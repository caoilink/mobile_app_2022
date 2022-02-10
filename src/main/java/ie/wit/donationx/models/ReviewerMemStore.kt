package ie.wit.donationx.models

import timber.log.Timber

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class ReviewerMemStore : ReviewerStore {

    val reviewers = ArrayList<ReviewerModel>()

    override fun findAll(): List<ReviewerModel> {
        return reviewers
    }

    override fun findById(id:Long) : ReviewerModel? {
        val foundReviewer: ReviewerModel? = reviewers.find { it.id == id }
        return foundReviewer
    }

    override fun create(reviewer: ReviewerModel) {
        reviewer.id = getId()
        reviewers.add(reviewer)
        logAll()
    }

    fun logAll() {
        Timber.v("** Donations List **")
        reviewers.forEach { Timber.v("Donate ${it}") }
    }
}