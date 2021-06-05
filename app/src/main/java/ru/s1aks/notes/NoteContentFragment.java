package ru.s1aks.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        setHasOptionsMenu(true);
        initView(view);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.note_content_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.actionEdit){
            Toast.makeText(getContext(), "Chosen edit note", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("SetTextI18n")
    private void initView(View view) {
        LinearLayout noteContentLayout = (LinearLayout) view;
        TextView titleTextView = new TextView(getContext());
        int noteContentPadding = getResources().getInteger(R.integer.noteContentPadding);
        titleTextView.setPadding(
                noteContentPadding,
                noteContentPadding,
                noteContentPadding,
                noteContentPadding
        );
        titleTextView.setText(AppData.notes.get(index).getTitle());
        titleTextView.setTextSize(getResources().getInteger(R.integer.lineTitleTextSize));
        noteContentLayout.addView(titleTextView);
        TextView contentTextView = new TextView(getContext());
        contentTextView.setPadding(
                noteContentPadding,
                noteContentPadding,
                noteContentPadding,
                noteContentPadding
        );
        contentTextView.setText(AppData.notes.get(index).getContent());
        contentTextView.setTextSize(getResources().getInteger(R.integer.contentTextSize));
        noteContentLayout.addView(contentTextView);
        TextView createTimeTextView = new TextView(getContext());
        createTimeTextView.setPadding(
                noteContentPadding,
                noteContentPadding,
                noteContentPadding,
                noteContentPadding
        );
        createTimeTextView.setText("Created in " + AppData.notes.get(index).getStringCreateTime());
        createTimeTextView.setTextSize(getResources().getInteger(R.integer.lineTimeTextSize));
        noteContentLayout.addView(createTimeTextView);
        Button buttonDateEdit = new Button(getContext());
        buttonDateEdit.setText("Edit date");
        buttonDateEdit.setTextSize(getResources().getInteger(R.integer.lineTimeTextSize));
        buttonDateEdit.setOnClickListener(v -> {
            FragmentChangeListener fragmentChangeListener = (FragmentChangeListener) getActivity();
            assert fragmentChangeListener != null;
            fragmentChangeListener.replaceFragment(DatePickerFragment.newInstance(index));
        });
        noteContentLayout.addView(buttonDateEdit);

    }
}