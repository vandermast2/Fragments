package sss.com.fragments.ui.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sss.com.fragments.BuildConfig;
import sss.com.fragments.R;
import sss.com.fragments.models.RecipeModel;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private TextView txtDescription;
    private Button deleteItem;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
        deleteItem = itemView.findViewById(R.id.btnDeleteItem);
    }

    public void onBind(RecipeModel recipeModel, MyRVAdapter.OnItemClick listener){
        txtTitle.setText(recipeModel.getTitle());
        txtDescription.setText(recipeModel.getDescription());
        deleteItem.setOnClickListener(v->listener.onClick(recipeModel));
    }
}
