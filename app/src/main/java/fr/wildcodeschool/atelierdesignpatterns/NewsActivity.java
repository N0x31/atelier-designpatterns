package fr.wildcodeschool.atelierdesignpatterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        TextView headline = findViewById(R.id.newsitem_headline);
        TextView content = findViewById(R.id.newsitem_content);

        // TODO : show headline and content
        Intent intent = getIntent();

        String newHeadline = intent.getStringExtra("headline");
        String newContent = intent.getStringExtra("newsContent");

        headline.setText(newHeadline);
        content.setText(newContent);


    }
}
