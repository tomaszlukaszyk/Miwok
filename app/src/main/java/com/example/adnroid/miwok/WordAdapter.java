package com.example.adnroid.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
* {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Word} objects.
* */

public class WordAdapter extends ArrayAdapter<Word> {

    // Holds the background color for views to be created
    private int mBackgroundColor;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context         The current context. Used to inflate the layout file.
     * @param words           A List of Word objects to display in a list
     * @param backgroundColor is the resource ID for the background color for this list of words
     */
    public WordAdapter(Context context, ArrayList<Word> words, int backgroundColor) {
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current Word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the text container View
        View textViewContainer = listItemView.findViewById(R.id.text_view_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        // Set the background color of the text container View
        textViewContainer.setBackgroundColor(color);

        // Find the ImageView in the list_item.xml layout with the ID list_image_view
        ImageView iconView = listItemView.findViewById(R.id.list_image_view);
        // Get the image resource ID from the current Word object and
        // set the image to iconView
        if (currentWord.hasImage()) {
            // make sure the image is visible
            iconView.setVisibility(View.VISIBLE);
            // set the ImageView to the image resource specified in the current Word object
            iconView.setImageResource(currentWord.getImageResourceId());
        } else {
            // otherwise hide the image
            iconView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the AdapterView
        return listItemView;
    }
}
