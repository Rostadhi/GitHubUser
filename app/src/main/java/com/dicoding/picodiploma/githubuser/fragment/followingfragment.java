package com.dicoding.picodiploma.githubuser.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.picodiploma.githubuser.R;
import com.dicoding.picodiploma.githubuser.adapter.AdapterFragment;
import com.dicoding.picodiploma.githubuser.model.User;
import com.dicoding.picodiploma.githubuser.retrofit.APIClient;
import com.dicoding.picodiploma.githubuser.retrofit.RetrofitConfiguration;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class followingfragment extends Fragment {
    private RecyclerView recyclerView;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ITEM_NUMBER = "ITEM_number";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public followingfragment() {
        // Required empty public constructor
    }
    public static followingfragment newInstance(int index){
        followingfragment following = new followingfragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_ITEM_NUMBER, index);
        following.setArguments(bundle);
        return following;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Followers.
     */
    // TODO: Rename and change types and number of parameters
    public static followingfragment newInstance(String param1, String param2) {
        followingfragment fragment = new followingfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_following, container,false);
        showrecycler(view);
        return view;
    }

    private void showrecycler(View view) {
        recyclerView = view.findViewById(R.id.rv_user2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        User user = Objects.requireNonNull(getActivity()).getIntent().getParcelableExtra("DATA_USER");
        APIClient api = RetrofitConfiguration.getRetrofit().create(APIClient.class);
        Call<List<User>> call = api.getFollowing(Objects.requireNonNull(user).getLogin());
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                AdapterFragment adapterFragment = new AdapterFragment(getContext(), response.body());
                recyclerView.setAdapter(adapterFragment);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
