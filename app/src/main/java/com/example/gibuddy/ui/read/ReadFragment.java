package com.example.gibuddy.ui.read;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gibuddy.R;

public class ReadFragment extends Fragment {

  private ReadViewModel homeViewModel;
  public double[] readings = new double[2];
  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {

   ///app/src/main/java/com.example.gibuddy/res/layout/raw/values.txt
    String path="";
    File f=new File("values.txt");
    path=f.getAbsolutePath();
    Log.e("path",path);
    try {
      Scanner sc = new Scanner(new File("C://Users/rbroc/AndroidStudioProjects/GIBuddy_New/app/src/main/java/com/example/gibuddy/values.txt"));
      int count = 0;
      while(sc.hasNext()) {
        readings[count] = Double.parseDouble(sc.nextLine());
        count++;
        Log.e("readings",readings[count-1]+"");

      }

    } catch(FileNotFoundException e) {
      Log.e("err","uhooh");
    }
    catch (Exception t) {
      Log.e("err","sandwich");
    }

    homeViewModel =
            new ViewModelProvider(this).get(ReadViewModel.class);
    View root = inflater.inflate(R.layout.fragment_read, container, false);
    final TextView textView = root.findViewById(R.id.text_read);
    homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}