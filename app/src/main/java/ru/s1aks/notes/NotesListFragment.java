package ru.s1aks.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static ru.s1aks.notes.AppData.LINE_TIME_TEXT_SIZE;
import static ru.s1aks.notes.AppData.LINE_TITLE_TEXT_SIZE;
import static ru.s1aks.notes.AppData.MAIN_LAYOUT_PADDING;
import static ru.s1aks.notes.AppData.NOTE_LINE_MARGIN;
import static ru.s1aks.notes.AppData.NOTE_LINE_PADDING;
import static ru.s1aks.notes.AppData.notes;

public class NotesListFragment extends Fragment {

    public NotesListFragment() {
    }

    public static NotesListFragment newInstance() {
        return new NotesListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes_list, container, false);
        createNotesList();
        initList(view);
        return view;
    }

    private void createNotesList() {
        notes = new ArrayList<>();
        notes.add(new Note("Title 1", "Content 1",
                new GregorianCalendar(2021, 2, 2, 11, 34),
                1));
        notes.add(new Note("Title 2", "Content 2",
                new GregorianCalendar(2021, 3, 2, 14, 6),
                1));
        notes.add(new Note("Title 3", "Content 3",
                new GregorianCalendar(2021, 3, 3, 19, 15),
                1));
        notes.add(new Note("Title 4", "Content 4",
                new GregorianCalendar(2021, 3, 5, 22, 54),
                1));
        notes.add(new Note("Title 5", "Content 5",
                new GregorianCalendar(2021, 4, 8, 23, 38),
                1));
        notes.add(new Note("Title 6", "Content 6",
                new GregorianCalendar(2021, 4, 10, 8, 2),
                1));
        notes.add(new Note("Title 7", "Content 7",
                new GregorianCalendar(2021, 4, 12, 14, 31),
                1));
    }

    @SuppressLint("ResourceAsColor")
    private void initList(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        view.setPadding(
                MAIN_LAYOUT_PADDING,
                0,
                MAIN_LAYOUT_PADDING,
                0);
        for (int i = 0; i < notes.size(); i++) {
            LinearLayout noteLineLayout = new LinearLayout(getContext());
            noteLineLayout.setOrientation(LinearLayout.VERTICAL);
            noteLineLayout.setBackgroundColor(R.color.design_default_color_on_primary);
            noteLineLayout.setPadding(
                    NOTE_LINE_PADDING * 2,
                    NOTE_LINE_PADDING,
                    NOTE_LINE_PADDING,
                    NOTE_LINE_PADDING);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(
                    NOTE_LINE_MARGIN,
                    NOTE_LINE_MARGIN,
                    NOTE_LINE_MARGIN,
                    0);
            TextView titleTextView = new TextView(getContext());
            titleTextView.setText(notes.get(i).getTitle());
            titleTextView.setTextSize(LINE_TITLE_TEXT_SIZE);
            noteLineLayout.addView(titleTextView);
            TextView timeTextView = new TextView(getContext());
            timeTextView.setGravity(Gravity.END);
            timeTextView.setText(notes.get(i).getStringCreateTime());
            timeTextView.setTextSize(LINE_TIME_TEXT_SIZE);
            noteLineLayout.addView(timeTextView);
            final int fi = i;
            noteLineLayout.setOnClickListener(v -> changeFragment(fi));
            linearLayout.addView(noteLineLayout, layoutParams);
            linearLayout.requestLayout();
        }
    }

    private void changeFragment(int index) {
        FragmentChangeListener fragmentChangeListener = (FragmentChangeListener) getActivity();
        assert fragmentChangeListener != null;
        fragmentChangeListener.replaceFragment(NoteContentFragment.newInstance(index));

    }

}