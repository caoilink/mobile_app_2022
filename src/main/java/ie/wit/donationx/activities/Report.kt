package ie.wit.donationx.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import ie.wit.donationx.R
import ie.wit.donationx.databinding.ActivityReportBinding
import ie.wit.donationx.main.ReviewerXApp
import ie.wit.donationx.activities.Review


import ie.wit.donationx.activities.MainApp
import ie.wit.donationx.adapters.ReviewerAdapter
import ie.wit.donationx.models.ReviewerModel

/*
class Report : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityReviewListBinding
    private lateinit var refreshIntentLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        loadPlacemarks()

        registerRefreshCallback()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, ReviewActivity::class.java)
                refreshIntentLauncher.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onReviewClick(review: ReviewerModel) {
        val launcherIntent = Intent(this, ReviewerActivity::class.java)
        launcherIntent.putExtra("reviewer_edit", reviewer)
        refreshIntentLauncher.launch(launcherIntent)
    }

    private fun registerRefreshCallback() {
        refreshIntentLauncher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult())
                { loadReviews() }
    }

    private fun loadReviews() {
        showReviews(app.reviews.findAll())
    }

    fun showReviews (reviews: List<ReviewerModel>) {
        binding.recyclerView.adapter = ReviewerAdapter(reviews, this)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}
*/

class Report : AppCompatActivity() {

    lateinit var app: ReviewerXApp
    lateinit var reportLayout: ActivityReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportLayout = ActivityReportBinding.inflate(layoutInflater)
        setContentView(reportLayout.root)

        app = this.application as ReviewerXApp
        reportLayout.recyclerView.layoutManager = LinearLayoutManager(this)
        reportLayout.recyclerView.adapter = ReviewerAdapter(app.reviewersStore.findAll())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_report, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_review -> {
                startActivity(
                        Intent(this,
                                Review::class.java)
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
/*
class Report : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_report)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
      // Inflate the menu; this adds items to the action bar if it is present.
      menuInflater.inflate(R.menu.menu_report, menu)
      return true
  }*/
