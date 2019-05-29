package com.abiolasoft.xposedcadspurgearcalculator.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.abiolasoft.xposedcadspurgearcalculator.R;

public class FormulaeAdapter extends RecyclerView.Adapter<FormulaeAdapter.ViewHolder> {
    private int[] formula_images;

    public FormulaeAdapter(int[] formula_images) {
        this.formula_images = formula_images;
    }

    @NonNull
    @Override
    public FormulaeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gear_formulae_single, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormulaeAdapter.ViewHolder holder, int position) {

        holder.formula_iv.setImageResource(formula_images[position]);

    }

    @Override
    public int getItemCount() {
        return formula_images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView formula_iv;

        public ViewHolder(View itemView) {
            super(itemView);

            formula_iv = itemView.findViewById(R.id.formula_image);
        }
    }
}
