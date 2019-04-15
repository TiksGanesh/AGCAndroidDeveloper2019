package com.example.notes.pojo;

/**
 * Class:       NoteModel
 * Description: NoteModel is POJO class to store note data
 */
public class NoteModel {

    private int id;
    private String noteTitle;
    private String noteDescription;
    private String noteTimeStamp;

    public NoteModel() {
        // Keep This NoteModel Constructor
    }

    public NoteModel(int id, String noteTitle, String noteDescription, String noteTimeStamp) {
        this.id = id;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.noteTimeStamp = noteTimeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getNoteTimeStamp() {
        return noteTimeStamp;
    }

    public void setNoteTimeStamp(String noteTimeStamp) {
        this.noteTimeStamp = noteTimeStamp;
    }
}
