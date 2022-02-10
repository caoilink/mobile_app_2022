package ie.wit.donationx.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.donationx.R
import ie.wit.donationx.databinding.CardReviewerBinding
import ie.wit.donationx.models.ReviewerModel
/*import ie.wit.reviewerx.databinding.CardReviewerBinding
import ie.wit.reviewerx.R
import ie.wit.reviewerx.databinding.CardReviewerBinding
import ie.wit.reviewerx.models.ReviewerModel*/

class ReviewerAdapter constructor(private var reviewers: List<ReviewerModel>)
    : RecyclerView.Adapter<ReviewerAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardReviewerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val reviewer = reviewers[holder.adapterPosition]
        holder.bind(reviewer)
    }

    override fun getItemCount(): Int = reviewers.size

    inner class MainHolder(val binding : CardReviewerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(reviewer: ReviewerModel) {
            binding.paymentamount.text = reviewer.amount.toString()
            binding.paymentmethod.text = reviewer.paymentmethod
            binding.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}