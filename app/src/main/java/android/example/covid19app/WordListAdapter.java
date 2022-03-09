package android.example.covid19app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    @NonNull
    @org.jetbrains.annotations.NotNull

    //private final LinkedList<String> mWordList;
    private Hashtable<String, Integer> tmp;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, Hashtable<String, Integer> wordHash
                           /*LinkedList<String> wordList*/) {
        mInflater = LayoutInflater.from(context);
        //this.mWordList = wordList;
        this.tmp = wordHash;
    }


    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull WordListAdapter.WordViewHolder holder, int position) {
        //String mCurrent = mWordList.get(position);
        Set<String> keys = tmp.keySet();
        int i = 0;
        String mCurrent = "";
        for (String key : keys) {
            if (i == position) {
                mCurrent = String.format("%s:\t\t%d",key,tmp.get(key));
                break;
            }
            i++;
        }
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        //return mWordList.size();
        return tmp.size();
    }



    class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }

    }
}



