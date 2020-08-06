package com.cos.mvvmstudy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {

    // LiveData : getter 함수만 가지고 있음 - 변경 불가
    // MutableLiveData : getter, setter 함수 가지고 있음 - 변경 가능
    private MutableLiveData<List<Note>> allNotes = new MutableLiveData<>();

    // DB가 없기 때문에 테스트 용으로 데이터 초기화
    public NoteRepository() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("제목","설명",0));
        allNotes.setValue(notes);
    }

    public LiveData<List<Note>> findAll() {
        return allNotes;
    }

    public void delete(Note note) {
        List<Note> notes = allNotes.getValue();
        notes.remove(note);
        allNotes.setValue(notes);
    };

//    public void update() {
//        allNotes.addAll(allNotes);
//    };

    public void save(Note note) {
        List<Note> notes = allNotes.getValue();
        notes.add(note);
        allNotes.setValue(notes);
    };


}
