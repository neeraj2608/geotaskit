package com.cis6930.geotaskit.fragment;

import java.util.HashMap;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.cis6930.geotaskit.R;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

public class MyMapPopupHandler implements InfoWindowAdapter {
  
  private View view;
  private HashMap <Marker, MyMapTaskInfo> taskHash;

  public MyMapPopupHandler(LayoutInflater inflater, HashMap<Marker, MyMapTaskInfo> taskHash) {
    this.view = inflater.inflate(R.layout.mymapmarkerpopup_layout, null);
    this.taskHash = taskHash;
  }

  // if this returns null, getInfoContents is called
  @Override
  public View getInfoWindow(Marker marker) {
    return null;
  }

  @Override
  public View getInfoContents(Marker marker) {
    //retrieve the task information and display on the popup
    MyMapTaskInfo thisTask = taskHash.get(marker);
    ((TextView) view.findViewById(R.id.balloon_item_title)).setText(thisTask.getTaskDescription());
    return view;
  }
  
}