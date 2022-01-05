package com.example.collegeapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collegeapp.DepartmentDetailsActivity;
import com.example.collageapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


public class Home_fragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    SliderLayout sliderLayout;
    Button click_here;
    ImageView map;
    CardView cs_card,mech_card,civil_card,electrical_card,electronics_card;
    TextView seeAll;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        click_here= view.findViewById(R.id.dial_btn);
        map = view.findViewById(R.id.bitm_map);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300); //You can manage the blinking time with this parameter
        anim.setStartOffset(50);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        click_here.startAnimation(anim);


        sliderLayout = view.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :

        setSliderViews();
        click_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialNumber();
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        cs_card = view.findViewById(R.id.cse);
        cs_card.setOnClickListener(card);

        mech_card = view.findViewById(R.id.mech);
        mech_card.setOnClickListener(card);

        electrical_card = view.findViewById(R.id.ete);
        electrical_card.setOnClickListener(card);

        electronics_card = view.findViewById(R.id.etc);
        electronics_card.setOnClickListener(card);

        civil_card = view.findViewById(R.id.civil);
        civil_card.setOnClickListener(card);

        seeAll = view.findViewById(R.id.seeAllDept);
        seeAll.setOnClickListener(card);




        return view;
    }
    //open department details in webView
    public View.OnClickListener card = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cse:
                    startActivity(new Intent(getContext(), DepartmentDetailsActivity.class).putExtra("url","https://bitm.org.in/computer-science.php"));
                    break;
                case R.id.civil:
                    startActivity(new Intent(getContext(),DepartmentDetailsActivity.class).putExtra("url","https://bitm.org.in/civil.php"));
                    break;
                case R.id.mech:
                    startActivity(new Intent(getContext(),DepartmentDetailsActivity.class).putExtra("url","https://bitm.org.in/mechanical.php"));
                    break;
                case R.id.ete:
                    startActivity(new Intent(getContext(),DepartmentDetailsActivity.class).putExtra("url","https://bitm.org.in/electrical.php"));
                    break;
                case R.id.etc:
                    startActivity(new Intent(getContext(),DepartmentDetailsActivity.class).putExtra("url","https://bitm.org.in/electronics-communication.php"));
                    break;
                case R.id.seeAllDept:
                    startActivity(new Intent(getContext(),DepartmentDetailsActivity.class).putExtra("url","https://bitm.org.in/under-graduate.php"));
                    break;
            }
        }
    };

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Bengal Institute of Technology and Management, Sriniketan, West Bengal");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void dialNumber() {
        Uri number = Uri.parse("tel:9007030162");
        Intent intent = new Intent(Intent.ACTION_DIAL,number);
        startActivity(intent);
    }

    private void setSliderViews() {
        String url1,url2,url3,url4,url5;
        url1 ="https://firebasestorage.googleapis.com/v0/b/collegeadmin-3a7b2.appspot.com/o/Gallery%2F%5BB%402890a60_jpg?alt=media&token=77a799d5-7326-487b-843e-53cf2024beca" ;
        url2 ="https://firebasestorage.googleapis.com/v0/b/collegeadmin-3a7b2.appspot.com/o/Gallery%2F%5BB%40c0c27d0_jpg?alt=media&token=d05e9f70-c738-4515-b470-269f6adbe3db";
        url3 ="https://firebasestorage.googleapis.com/v0/b/collegeadmin-3a7b2.appspot.com/o/Gallery%2F%5BB%4046f2bf1_jpg?alt=media&token=b10c3143-ee8f-433c-9c59-406c17323f3f";
        url4 ="https://firebasestorage.googleapis.com/v0/b/collegeadmin-3a7b2.appspot.com/o/Gallery%2F%5BB%403d18fd_jpg?alt=media&token=799fdfa6-07a7-42a2-8dda-8f3de6e5df7d";
        url5 ="https://firebasestorage.googleapis.com/v0/b/collegeadmin-3a7b2.appspot.com/o/Gallery%2F%5BB%403d18fd_jpg?alt=media&token=799fdfa6-07a7-42a2-8dda-8f3de6e5df7d";



        for (int i = 0; i <= 4; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageUrl(url1);
                    break;
                case 1:
                    sliderView.setImageUrl(url2);
                    break;
                case 2:
                    sliderView.setImageUrl(url3);
                    break;
                case 3:
                    sliderView.setImageUrl(url4);
                    break;
                case 4:
                    sliderView.setImageUrl(url5);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("Bengal Institute of Technology and Management" + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //startActivity(new Intent(getContext(), NoticeDetailsActivity.class).putExtra("imageUrl"));
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}
