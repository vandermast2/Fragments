package sss.com.fragments.ui.fragments.monday;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import sss.com.fragments.R;
import sss.com.fragments.ui.adapters.MyRVAdapter;
import sss.com.fragments.models.RecipeModel;
import sss.com.fragments.ui.base.BaseFragment;

import static sss.com.fragments.utils.RecipeGenerator.generateRecipes;


public class MondayFragment extends BaseFragment {

    private RecyclerView rvList;
    private MyRVAdapter adapter;

    private Button btnAdd, btnDel;

    private ArrayList<RecipeModel> list;
    private final MyRVAdapter.OnItemClick listener = this::delete;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monday, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvList = view.findViewById(R.id.rvList);

        btnAdd = view.findViewById(R.id.btnAdd);
        btnDel = view.findViewById(R.id.btnDelete);

        btnDel.setOnClickListener(v -> delete());

        btnAdd.setOnClickListener(v -> add());
        list = (ArrayList<RecipeModel>) generateRecipes();
        adapter = new MyRVAdapter(list, listener);

        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        rvList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void delete(RecipeModel model){
        adapter.notifyItemRemoved(list.indexOf(model));
        list.remove(model);
    }

    private void delete() {
        adapter.notifyItemRemoved(list.size() - 1);
        list.remove(list.size() - 1);
    }

    private void add() {
        adapter.notifyItemInserted(0);
        list.add(0,new RecipeModel("Title", "Description"));
    }

    @Override
    public String getTitle() {
        return "Mon";
    }
}