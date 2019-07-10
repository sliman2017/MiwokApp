package com.hamdaouislimanedevand.android.miwokapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by slimane on 09/09/18.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    private int mResourceIdColor;
    Context context;

    public WordAdapter(Context context, ArrayList<Word> words, int ResourceIdColor) {
        super(context, 0, words);
        mResourceIdColor = ResourceIdColor;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Word currentWord = getItem(position);

        TextView textView = (TextView) listItemView.findViewById(R.id.textview_miwok);
        textView.setText(currentWord.getMiwokWord());
        TextView textView1 = (TextView) listItemView.findViewById(R.id.textview_english);
        textView1.setText(currentWord.getEnglishWord());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageview_button);

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getEmojis());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        View linearLayout = listItemView.findViewById(R.id.linearLayout_list_item);
        int color = ContextCompat.getColor(getContext(), mResourceIdColor);
        linearLayout.setBackgroundColor(color);

        ImageButton play = (ImageButton) listItemView.findViewById(R.id.play_imagebutton);
        ImageButton pause = (ImageButton) listItemView.findViewById(R.id.pause_imagebutton);
         final MediaPlayer mediaPlayer = MediaPlayer.create(context, currentWord.getIdResourceAudio());

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(context, "I am Done ", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        return listItemView;
    }

    public void mediaPlayerRelease(MediaPlayer mediaPlayer){
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}