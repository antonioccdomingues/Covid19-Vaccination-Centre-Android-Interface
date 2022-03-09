package android.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Hashtable;
import java.util.LinkedList;

public class Vacinas extends AppCompatActivity {

    //funções da recyclerLayout
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String> mWordList = new LinkedList<>();
    private Hashtable<String, Integer> doses_fabricante = new Hashtable<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);


        doses_fabricante.put("AstraZeneca", (int) (Math.random()*(150-3+1)+3));
        doses_fabricante.put("Pfizer", (int) (Math.random()*(150-3+1)+3));
        doses_fabricante.put("Moderna", (int) (Math.random()*(150-3+1)+3));
        doses_fabricante.put("J&J", (int) (Math.random()*(150-3+1)+3));
        doses_fabricante.put("Sputnik", (int) (Math.random()*(10-3+1)+3));


        //recycler layout
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new WordListAdapter(this, doses_fabricante);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}