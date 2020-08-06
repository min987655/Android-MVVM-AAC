package com.cos.mvvmstudy;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    // ViewModel이 가진 데이터
    private LiveData<List<Note>> allNotes;
    private NoteRepository noteRepository = new NoteRepository();

    public NoteViewModel(@NonNull Application application) {
        super(application);
        allNotes = noteRepository.findAll();
    }

    public LiveData<List<Note>> 구독하기() {
        return allNotes;
    }

    // -------- Service ---------
    public void 추가하기(Note note) {
        noteRepository.save(note);
    }

    public void 삭제하기(Note note){
        noteRepository.delete(note);
    }

//    최초에 한번 select 된 이후(구독하기) 알아서 변경되기 때문에 필요없음.
//    public LiveData<List<Note>> 전체보기() {
//        return noteRepository.findAll();
//    }
}
