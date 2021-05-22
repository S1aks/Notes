package ru.s1aks.notes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

    boolean isLandscape;
    NotesListFragment notesListFragment;
    NoteContentFragment noteContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
        notesListFragment = NotesListFragment.newInstance();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainContainer, notesListFragment)
                    .commit();
            if (isLandscape) {
                noteContentFragment = NoteContentFragment.newInstance(0);
                        getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentContainer, noteContentFragment)
                        .commit();
            }
        }
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        if (isLandscape) {
            fragmentTransaction.replace(R.id.contentContainer, fragment);
        } else {
            fragmentTransaction.replace(R.id.mainContainer, fragment)
                    .addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void closeFragment() {
        getSupportFragmentManager().popBackStack();
    }
}