package com.example.thesweetspot;

import java.util.List;

public class HomePageModel {
    public static final int BANNER_SLIDER=0;
    public static final int STRIP_AD_BANNER=1;

    private int type;



    //////////banner slider test
    private List<SliderModel> sliderModelList;
    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }
    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    //////////banner slider test

    //////////Strip ad layout
    private int resource;
    private String backgrounColour;

    public HomePageModel(int type, int resource, String backgrounColour) {
        this.type = type;
        this.resource = resource;
        this.backgrounColour = backgrounColour;
    }
    public int getResource() {
        return resource;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    public String getBackgrounColour() {
        return backgrounColour;
    }
    public void setBackgrounColour(String backgrounColour) {
        this.backgrounColour = backgrounColour;
    }
    //////////Strip ad layout


}
