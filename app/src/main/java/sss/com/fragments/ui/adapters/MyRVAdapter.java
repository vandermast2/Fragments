package sss.com.fragments.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sss.com.fragments.R;
import sss.com.fragments.models.RecipeModel;

public class MyRVAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<RecipeModel> recipeModels;
    private OnItemClick listener;

    public MyRVAdapter(List<RecipeModel> recipeModels, OnItemClick listener) {
        this.recipeModels = recipeModels;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(recipeModels.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return recipeModels.size();
    }

    public interface OnItemClick{
        public void onClick(RecipeModel model);
    }
}
