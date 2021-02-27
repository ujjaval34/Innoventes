package com.ujjaval.innoventes_task.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ujjaval.innoventes_task.MainActivity;
import com.ujjaval.innoventes_task.R;

public class SearchActivity extends AppCompatActivity {


    private EditText etSearchBox;
    private Button btnSearchMovie;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_trending:
                    Intent trendingIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(trendingIntent);
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_favorites:
                    Intent favoritesIntent = new Intent(getApplicationContext(), BookmarkActivity.class);
                    startActivity(favoritesIntent);
                    return true;
            }
            return false;
        }
    };


    private void submitSearch() {
        Intent intent = new Intent(getApplicationContext(), SearchResultsActivity.class);
        String TMDBQuery = etSearchBox.getText().toString();

        // Passing data to the Search Results activity
        intent.putExtra("SearchQuery", TMDBQuery);
        SearchActivity.this.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Set bottombar active item
        navigation.setSelectedItemId(R.id.navigation_search);

        etSearchBox = findViewById(R.id.et_search_box);
        btnSearchMovie = findViewById(R.id.btn_search_movie);

        // Set on click listener on button
        btnSearchMovie.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                submitSearch();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }
}