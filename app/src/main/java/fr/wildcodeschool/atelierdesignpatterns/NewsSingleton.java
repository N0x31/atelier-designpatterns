package fr.wildcodeschool.atelierdesignpatterns;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

class NewsSingleton extends Observable {

    private static NewsSingleton sInstance = null;
    private List<NewsModel> mNewsList = new ArrayList<>();

    private NewsSingleton() {

    }

    static NewsSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new NewsSingleton();
        }
        return sInstance;
    }

    void loadNews() {
        // TODO : load news from Firebase then notifiy observers
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("news");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List <NewsModel> newsList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    NewsModel newModel = snapshot.getValue(NewsModel.class);
                    newsList.add(newModel);
                }
                mNewsList = newsList;
                setChanged();
                notifyObservers();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    List<NewsModel> getNews() {
        return mNewsList;
    }
}
