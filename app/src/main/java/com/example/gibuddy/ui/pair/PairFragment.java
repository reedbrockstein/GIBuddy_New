package com.example.gibuddy.ui.pair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gibuddy.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class PairFragment extends Fragment {

  private PairViewModel notificationsViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    notificationsViewModel =
            new ViewModelProvider(this).get(PairViewModel.class);

    // Sets root UI for Pair frame (from fragment_pair.xml)
    View root = inflater.inflate(R.layout.fragment_pair, container, false);

    // Finds the textView in Pair frame
    final TextView textView = root.findViewById(R.id.text_pair);
    final TextView textViewDeviceName = root.findViewById(R.id.text_pair3);

    // Pair Button functionality
    final Button buttonPair = root.findViewById(R.id.buttonPair);
    PairViewModel model = new ViewModelProvider(this).get(PairViewModel.class);
    buttonPair.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        // Code here executes on main thread after user presses button
        //model.setUpBluetoothAdapter();
        Snackbar mySnackbar = Snackbar.make(root, "Please pair your GIBuddy in the Settings app", BaseTransientBottomBar.LENGTH_INDEFINITE).setAction("OPEN SETTINGS APP", new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            startActivityForResult(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS), 0);
          }
        });
        mySnackbar.show();
      }
    });

    notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textViewDeviceName.setText(s);
        //textView2.setText(s);
      }
    });

    return root;

  }
}