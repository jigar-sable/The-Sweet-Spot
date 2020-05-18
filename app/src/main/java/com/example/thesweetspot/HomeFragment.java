package com.example.thesweetspot;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    //////////banner slider test
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    //////////banner slider test


    //////////Strip ad layout
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;
    //////////Strip ad layout

    //////////Horizontal product layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerview;
    //////////Horizontal product layout



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("Link", "Home"));
        categoryModelList.add(new CategoryModel("Link", "Electronic"));
        categoryModelList.add(new CategoryModel("Link", "Appliances"));
        categoryModelList.add(new CategoryModel("Link", "Furniture"));
        categoryModelList.add(new CategoryModel("Link", "Fashion"));
        categoryModelList.add(new CategoryModel("Link", "Toys"));
        categoryModelList.add(new CategoryModel("Link", "Sports"));
        categoryModelList.add(new CategoryModel("Link", "Wall Arts"));
        categoryModelList.add(new CategoryModel("Link", "Books"));
        categoryModelList.add(new CategoryModel("Link", "Footwear"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        //////////banner slider test

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_viewPager);

        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.account_icon,"#077ae4"));
        sliderModelList.add(new SliderModel(R.drawable.gift_icon,"#077ae4"));
        sliderModelList.add(new SliderModel(R.mipmap.logo,"#077ae4"));

        sliderModelList.add(new SliderModel(R.drawable.mail_red,"#077ae4"));
        sliderModelList.add(new SliderModel(R.drawable.mail_green,"#077ae4"));
        sliderModelList.add(new SliderModel(R.drawable.cart_icon,"#077ae4"));
        sliderModelList.add(new SliderModel(R.drawable.home_icon,"#077ae4"));
        sliderModelList.add(new SliderModel(R.drawable.banner,"#077ae4"));

        sliderModelList.add(new SliderModel(R.drawable.gift_icon,"#077ae4"));
        sliderModelList.add(new SliderModel(R.mipmap.logo,"#077ae4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_clear_black_18dp,"#077ae4"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    pageLooper();
                }
            }
        };

        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideshow();
        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideshow();

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    startBannerSlideshow();
                }
                return false;
            }
        });

        //////////banner slider test

        //////////Strip ad layout
        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.stripad);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));

        //////////Strip ad layout



        //////////Horizontal product layout

        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalRecyclerview = view.findViewById(R.id.horizontal_scroll_layout_recyclerView);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all_button);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.mobile_image,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.account_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cart_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.mail_green,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.mail_red,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.gift_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.signout_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.my_sweet_spot_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        horizontalRecyclerview.setLayoutManager(linearLayoutManager);
        horizontalRecyclerview.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        //////////Horizontal product layout

        //////////Grid Product Layout
        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_viewall_button);
        GridView gridView = view.findViewById(R.id.grid_product_layout_grid_view);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));
        //////////Grid Product Layout

        return view;
    }

    //////////banner slider test
    private void pageLooper() {
        if (currentPage == sliderModelList.size() - 2) {
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }
        if (currentPage == 1) {
            currentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }
    }

    private void startBannerSlideshow() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()) {
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_TIME, PERIOD_TIME);
    }

    private void stopBannerSlideshow() {
        timer.cancel();
    }
    //////////banner slider test


}
