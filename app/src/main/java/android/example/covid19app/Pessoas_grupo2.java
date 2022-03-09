package android.example.covid19app;

import android.annotation.SuppressLint;
import android.example.covid19app.Warnings.LembreteWarning;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import java.util.ArrayList;

public class Pessoas_grupo2 extends AppCompatActivity implements View.OnClickListener{

    // List View object
    ListView listView;

    // Define array adapter for ListView
    ArrayAdapter<String> adapter;

    // Define array List for List View data
    ArrayList<String> mylist;

    //Define button for lembrete
    Button blembrete;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoas_grupo);

        // initialise ListView with id
        listView = findViewById(R.id.listView);

        //initialise button with id
        blembrete = (Button) findViewById(R.id.button_lembrete);
        blembrete.setOnClickListener(this);

        // Add items to Array List
        mylist = new ArrayList<>();
        mylist.add("Alberta Vieira");
        mylist.add("Tomas Pedrosa");
        mylist.add("Beatriz Bento");
        mylist.add("Filipe Soares");
        mylist.add("Jorge Sousa");
        mylist.add("Catarina Malheiro");
        mylist.add("Jose Fernandes");
        mylist.add("José Manuel");
        mylist.add("Gil do Pernil");
        // Set adapter to ListView
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylist){
            @SuppressLint("ResourceType")
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //Get current item for ListView
                View view = super.getView(position, convertView, parent);
                Log.d("pos", "pos:"+position);
                Log.d("vt", "view.getText"+((TextView) view ).getText().toString());

                for(int i=0; i<3; i++){
                    if(((TextView) view ).getText().toString().equals(mylist.get(i))){
                        view.setBackgroundColor(Color.RED);
                    }
                }

                for(int i=4; i<9; i++){
                    if(((TextView) view ).getText().toString().equals(mylist.get(i))){
                        view.setBackgroundColor(Color.GREEN);
                    }
                }

                if(((TextView) view ).getText().toString().equals("Filipe Soares")){
                    view.setBackgroundColor(Color.YELLOW);

                }

                return view;
            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate menu with items using MenuInflator
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // Initialise menu item search bar
        // with id and take its object
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);

        // attach setOnQueryTextListener
        // to search view defined above
        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {

                    // Override onQueryTextSubmit method
                    // which is call
                    // when submitquery is searched

                    @Override
                    public boolean onQueryTextSubmit(String query)
                    {
                        // If the list contains the search query
                        // than filter the adapter
                        // using the filter method
                        // with the query as its argument
                        if (mylist.contains(query)) {
                            adapter.getFilter().filter(query);
                        }
                        else {
                            // Search query not found in List View
                            Toast
                                    .makeText(Pessoas_grupo2.this,
                                            "Not found",
                                            Toast.LENGTH_LONG)
                                    .show();
                        }
                        return false;
                    }

                    // This method is overridden to filter
                    // the adapter according to a search query
                    // when the user is typing search
                    @Override
                    public boolean onQueryTextChange(String newText)
                    {
                        adapter.getFilter().filter(newText);
                        return false;
                    }
                });

        return super.onCreateOptionsMenu(menu);
    }

    public void onClick(View v) {

        if(v.getId() == R.id.button_lembrete){
            openLembrete();
            Log.d("test1","lembrete");
        }
    }

    public void openLembrete(){
        LembreteWarning lembreteWarning = new LembreteWarning();
        lembreteWarning.show(getSupportFragmentManager(), "lembrete Warning"); // "login warning" = tag
    }

}

