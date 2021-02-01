package sss.com.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import sss.com.fragments.adapters.MyRVAdapter;
import sss.com.fragments.models.RecipeModel;


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

    private List<RecipeModel> generateRecipes(){
        ArrayList<RecipeModel> tmp = new ArrayList<>();
        for (int i = 0; i< 10; i++){
            tmp.add(new RecipeModel("Title " + i, "Description " + i));
        }
        return tmp;
    }

    @Override
    public String getTitle() {
        return "Mon";
    }
}