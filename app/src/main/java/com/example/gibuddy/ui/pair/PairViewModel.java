package com.example.gibuddy.ui.pair;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PairViewModel extends ViewModel {

  private MutableLiveData<String> mText;
  private BluetoothAdapter bluetoothAdapter;

  public PairViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is pair fragment");

    setUpBluetoothAdapter();
  }

  public LiveData<String> getText() {
    return mText;
  }

  private void setUpBluetoothAdapter() {
    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (bluetoothAdapter == null) {
      mText.setValue("Your device doesn't support Bluetooth");
    }

    if (bluetoothAdapter.isEnabled()) {
      Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
      // line below this doesn't work
//      startBluetoothActivity(enableBluetoothIntent, REQUEST_ENABLE_BT);
    }
  }
}