package ie.wit.donationx.models

interface ReviewerStore {
    fun findAll() : List<ReviewerModel>
    fun findById(id: Long) : ReviewerModel?
    fun create(reviewer: ReviewerModel)
}