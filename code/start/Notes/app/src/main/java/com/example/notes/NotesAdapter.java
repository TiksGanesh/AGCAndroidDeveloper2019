package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notes.pojo.NoteModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class:       NotesAdapter
 * Description: Adapter class is used for RecyclerView Notes from MainActivity
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesItemViewHolder> {

    private List<NoteModel> listOfNotes = new ArrayList<>();


    @NonNull
    @Override
    public NotesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_item, parent, false);
        return new NotesItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesItemViewHolder holder, int position) {
        NoteModel model = listOfNotes.get(position);
        holder.noteTitle.setText(model.getNoteTitle());
        holder.noteDescription.setText(model.getNoteDescription());
        holder.noteTimeStamp.setText(model.getNoteTimeStamp());
    }

    @Override
    public int getItemCount() {
        return listOfNotes.size();
    }

    /**
     * Update Notes
     * @param list list of NoteModel
     */
    public void updateNotes(List<NoteModel> list){
        if (null !=list && !list.isEmpty()){
            listOfNotes.clear();
            listOfNotes.addAll(list);
            notifyDataSetChanged();
        }
    }

    /**
     * ViewHolder class for layout -> note_item.xml
     */
    class NotesItemViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView noteTitle;
        AppCompatTextView noteDescription;
        AppCompatTextView noteTimeStamp;


        NotesItemViewHolder(@NonNull View itemView) {
            super(itemView);

            noteTitle = itemView.findViewById(R.id.noteTitle);
            noteDescription = itemView.findViewById(R.id.noteDetail);
            noteTimeStamp = itemView.findViewById(R.id.noteTimeStamp);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

}
