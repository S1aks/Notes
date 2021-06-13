package ru.s1aks.notes;

public interface NoteSource {
    NoteData getNoteData(int position);
    int size();
}
