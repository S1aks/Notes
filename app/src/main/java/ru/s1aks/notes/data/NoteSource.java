package ru.s1aks.notes.data;

import ru.s1aks.notes.data.NoteData;

public interface NoteSource {

    NoteData getNoteData(int position);

    int size();

    void updateNoteData(int position, NoteData noteData);

    void deleteNoteData(int position);
}
