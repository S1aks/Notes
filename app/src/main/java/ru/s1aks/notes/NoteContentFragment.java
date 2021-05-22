package ru.s1aks.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NoteContentFragment extends Fragment {

    private static final String ARG_INDEX = "index";
    private int index;

    public NoteContentFragment() {
    }

    public static NoteContentFragment newInstance(int index) {
        NoteContentFragment fragment = new NoteContentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_content, container, false);
        initView(view);
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void initView(View view) {
        LinearLayout noteContentLayout = (LinearLayout) view;
        TextView titleTextView = new TextView(getContext());
        titleTextView.setPadding(
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING
        );
        titleTextView.setText(AppData.notes.get(index).getTitle());
        titleTextView.setTextSize(AppData.LINE_TITLE_TEXT_SIZE);
        noteContentLayout.addView(titleTextView);
        TextView contentTextView = new TextView(getContext());
        contentTextView.setPadding(
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING
        );
        contentTextView.setText(AppData.notes.get(index).getContent());
        contentTextView.setTextSize(AppData.CONTENT_TEXT_SIZE);
        noteContentLayout.addView(contentTextView);
        TextView createTimeTextView = new TextView(getContext());
        createTimeTextView.setPadding(
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING,
                AppData.NOTE_CONTENT_PADDING
        );
        createTimeTextView.setText("Создано в " + AppData.notes.get(index).getStringCreateTime());
        createTimeTextView.setTextSize(AppData.LINE_TIME_TEXT_SIZE);
        noteContentLayout.addView(createTimeTextView);
    }
}