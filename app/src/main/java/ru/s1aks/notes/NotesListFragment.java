package ru.s1aks.notes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class NotesListFragment extends Fragment {

    ArrayList<Note> notes;

    public NotesListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createNotesList();
        initList(view);
    }

    private void createNotesList() {
        notes = new ArrayList<>();
        notes.add(new Note("Title 1", "Content 1",
                new GregorianCalendar(2021, 5, 2, 11, 34),
                1));
        notes.add(new Note("Title 2", "Content 2",
                new GregorianCalendar(2021, 5, 2, 14, 6),
                1));
        notes.add(new Note("Title 3", "Content 3",
                new GregorianCalendar(2021, 5, 3, 19, 15),
                1));
        notes.add(new Note("Title 4", "Content 4",
                new GregorianCalendar(2021, 5, 5, 22, 54),
                1));
        notes.add(new Note("Title 5", "Content 5",
                new GregorianCalendar(2021, 5, 8, 23, 38),
                1));
        notes.add(new Note("Title 6", "Content 6",
                new GregorianCalendar(2021, 5, 10, 8, 2),
                1));
        notes.add(new Note("Title 7", "Content 7",
                new GregorianCalendar(2021, 5, 12, 14, 31),
                1));
    }

    private void initList(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        for (Note note : notes) {
            TextView textView = new TextView(this.getContext());
            textView.setText(note.getTitle());
            textView.setTextSize(30);
            linearLayout.addView(textView);
            linearLayout.requestLayout();
        }
    }
}