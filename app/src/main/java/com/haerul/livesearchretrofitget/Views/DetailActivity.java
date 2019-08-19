package com.kotlin.myapplication.Views;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.kotlin.myapplication.Helpers.Utils;
import com.kotlin.myapplication.R;
import com.kotlin.myapplication.Retrofit.Scientist;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    //Let's define our instance fields
    private TextView titleTV, authorTV;

    private Scientist receivedScientist;

    /**
     * Let's initialize our widgets
     */
    private void initializeWidgets(){
        titleTV = findViewById(R.id.nameTV);
        authorTV = findViewById(R.id.descriptionTV);

    }

    /**
     * We will now receive and show our data to their appropriate views.
     */
    private void receiveAndShowData(){
         receivedScientist= Utils.receiveScientist(getIntent(),DetailActivity.this);

         if(receivedScientist != null){
             titleTV.setText(receivedScientist.getTitle());
             authorTV.setText(receivedScientist.getAuthor());



         }
    }
    /**
     * Let's inflate our menu for the detail page
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_page_menu, menu);
        return true;
    }

    /**
     * When a menu item is selected we want to navigate to the appropriate page
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Let's once again override the attachBaseContext. We do this for our
     * Calligraphy library
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    /**
     * Let's finish the current activity when back button is pressed
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
    /**
     * Our onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_content);

        initializeWidgets();
        receiveAndShowData();
    }

    @Override
    public void onClick(View view) {

    }
}
//end
