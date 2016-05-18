package com.example.riteshlocal.githubexample;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.riteshlocal.githubexample.Adapter.AdapterHotEvents;
import com.example.riteshlocal.githubexample.Model.HotEventListModel;
import com.example.riteshlocal.githubexample.Bean.ResponseBean;
import com.example.riteshlocal.githubexample.Service.CallAPI;
import com.google.gson.Gson;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<ResponseBody> {

    ArrayList<HotEventListModel> hotEventList = new ArrayList<HotEventListModel>();
    AdapterHotEvents mAdapter;
    View mHotEventView;

    @Bind(R.id.user_list_recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.represh_data_tv)
    TextView mTv_reload;

    @Bind(R.id.progressBar)
    CircleProgressBar progress;


    boolean checkprogressvalidation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        // 2. set layoutManger
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        // 3. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mTv_reload.setVisibility(View.INVISIBLE);
        if (hotEventList.size() > 0) {
            hotEventList.clear();
        }

        callAPI();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTv_reload.setVisibility(View.INVISIBLE);

                if (hotEventList.size() > 0) {
                    hotEventList.clear();
                }

                callAPI();
            }
        });
    }



    public void callAPI() {

        if (checkprogressvalidation == false) {
            progress.setVisibility(View.VISIBLE);
        }


        String baseUrl = "http://mobilytedev.com/livepopcorn/app/";
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ;
        CallAPI api = retrofit.create(CallAPI.class);
        Call<ResponseBody> call = api.getEventList("a152e84173914146e4bc4f391sd0f686ebc4f31","1");
        call.enqueue(this);
    }


    @Override
    public void onResponse(Response<ResponseBody> response) {
        try {

            checkprogressvalidation = true;

            progress.setVisibility(View.GONE);
            mSwipeRefreshLayout.setRefreshing(false);
            Gson gson = new Gson();
            ResponseBean responseBean = gson.fromJson(response.body().string(), ResponseBean.class);
            if (responseBean.getStatus().equals("1")) {

                // System.out.println("Response is = "+response);
                for (HotEventListModel data : responseBean.getEvents().getHot_event_list_model()) {

                    hotEventList.add(data);
                }

                if (hotEventList.size() > 0) {
                    mTv_reload.setVisibility(View.INVISIBLE);
                    mAdapter = new AdapterHotEvents(this, hotEventList);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    mTv_reload.setVisibility(View.VISIBLE);
                    Toast.makeText(this, "No event available.", Toast.LENGTH_LONG).show();
                }


            } else {
                mTv_reload.setVisibility(View.VISIBLE);
                Toast.makeText(this, "No event available.", Toast.LENGTH_LONG).show();
                System.out.println("else login called");
            }

        } catch (
                Exception e
                ) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        progress.setVisibility(View.GONE);
        checkprogressvalidation = true;
        mTv_reload.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this, "Facing Problem Connecting With Server", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.represh_data_tv)
    public void methodTvReloadApi(View view) {
        mTv_reload.setVisibility(View.INVISIBLE);
        mSwipeRefreshLayout.setRefreshing(true);
        if (hotEventList.size() > 0) {
            hotEventList.clear();
        }

        callAPI();

    }


    @Override
    public void onResume() {
        super.onResume();
        checkprogressvalidation = false;
    }



}
