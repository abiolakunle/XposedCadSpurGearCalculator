package com.abiolasoft.xposedcadspurgearcalculator.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abiolasoft.xposedcadspurgearcalculator.R;
import com.abiolasoft.xposedcadspurgearcalculator.utils.LetterImageView;

import java.util.Map;

public class TermsAdapter extends RecyclerView.Adapter<TermsAdapter.ViewHolder> {
    private Map<String, String> terms_description;
    private String[] terms;

    public TermsAdapter(String[] terms, Map<String, String> terms_description) {
        this.terms_description = terms_description;
        this.terms = terms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.terms_single, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.letterImageView.setLetter(terms[position].charAt(0));
        holder.letterImageView.setOval(true);
        holder.termNameTv.setText(terms[position]);
        holder.termDescTv.setText(terms_description.get(terms[position]));

    }

    @Override
    public int getItemCount() {
        return terms_description.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LetterImageView letterImageView;
        private TextView termNameTv;
        private TextView termDescTv;

        public ViewHolder(View itemView) {
            super(itemView);

            letterImageView = itemView.findViewById(R.id.term_letterImageView);
            termNameTv = itemView.findViewById(R.id.term_name_tv);
            termDescTv = itemView.findViewById(R.id.term_desc_tv);

        }
    }
}
