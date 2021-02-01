package sss.com.fragments.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sss.com.fragments.R;
import sss.com.fragments.models.RecipeModel;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private TextView txtDescription;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
    }

    public void onBind(RecipeModel recipeModel){
        txtTitle.setText(recipeModel.getTitle());
        txtDescription.setText(recipeModel.getDescription());
    }
}
