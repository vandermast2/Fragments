package sss.com.fragments.ui.fragments.monday;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monday,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvList = view.findViewById(R.id.rvList);
        adapter = new MyRVAdapter(generateRecipes());

        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        rvList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public String getTitle() {
        return "Mon";
    }
}