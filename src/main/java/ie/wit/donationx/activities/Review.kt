package ie.wit.donationx.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import ie.wit.donationx.R
import ie.wit.donationx.databinding.ActivityReviewerBinding
import ie.wit.donationx.main.ReviewerXApp
import ie.wit.donationx.models.ReviewerModel
/*import ie.wit.reviewerx.R
//import ie.wit.reviewerx.databinding.ActivityDonationBinding
import ie.wit.reviewerx.databinding.ActivityReviewerBinding
import ie.wit.reviewerx.main.ReviewerXApp
import ie.wit.reviewerx.models.ReviewerModel*/
import timber.log.Timber


class Review : AppCompatActivity() {

    private lateinit var reviewLayout : ActivityReviewerBinding
    lateinit var app: ReviewerXApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reviewLayout = ActivityReviewerBinding.inflate(layoutInflater)
        setContentView(reviewLayout.root)
        app = this.application as ReviewerXApp

        reviewLayout.progressBar.max = 10000

        reviewLayout.amountPicker.minValue = 1
        reviewLayout.amountPicker.maxValue = 1000

        reviewLayout.amountPicker.setOnValueChangedListener { _, _, newVal ->
            //Display the newly selected number to paymentAmount
            reviewLayout.paymentAmount.setText("$newVal")
        }

        var totalReviewed = 0

        //val edit: EditText = findViewById(R.id.editTextTextPersonName);
        //val result : String = edit.getText().toString();

        reviewLayout.reviewButton.setOnClickListener {

            val amount = if (reviewLayout.paymentAmount.text.isNotEmpty())
                reviewLayout.paymentAmount.text.toString().toInt() else reviewLayout.amountPicker.value
            val editName = reviewLayout.editTextTextPersonName.text.toString()
            if(totalReviewed >= reviewLayout.progressBar.max)
                Toast.makeText(applicationContext,"Treat yourself! Sorry we cannot handle a number that big", Toast.LENGTH_LONG).show()
            else {
                val paymentmethod = if(reviewLayout.paymentMethod.checkedRadioButtonId == R.id.Direct)
                    "Not Visit Again" else "Would Visit Again"
                totalReviewed += amount
                reviewLayout.totalSoFar.text = "$$totalReviewed"
                reviewLayout.progressBar.progress = totalReviewed
                //val edit: EditText1 = findViewById(R.id.editTextTextPersonName);
                //val result : String = edit.getText().toString();
                app.reviewersStore.create(ReviewerModel(editName = editName, paymentmethod = paymentmethod, amount = amount))
                Timber.i("Total Spent so far $totalReviewed")
            }
        }

        /*var totalDonated = 0

        reviewLayout.reviewButton.setOnClickListener {
            val amount = if (reviewLayout.paymentAmount.text.isNotEmpty())
                reviewLayout.paymentAmount.text.toString().toInt() else reviewLayout.amountPicker.value
            if(totalDonated >= reviewLayout.progressBar.max)
                Toast.makeText(applicationContext,"Donate Amount Exceeded!",Toast.LENGTH_LONG).show()
            else {
                totalDonated += amount
                reviewLayout.totalSoFar.text = "$$totalDonated"
                reviewLayout.progressBar.progress = totalDonated
                Timber.i("Total Donated so far $totalDonated")
            }
        }*/
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_review, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_report -> { startActivity(Intent(this, Report::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}