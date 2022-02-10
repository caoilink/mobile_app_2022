package ie.wit.donationx.models

import android.os.Parcelable
import android.widget.EditText
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReviewerModel(var id: Long = 0,
                         val paymentmethod: String = "N/A",

                         val amount: Int = 0,
                         val editName: String ): Parcelable