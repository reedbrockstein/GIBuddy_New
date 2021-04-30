package com.example.gibuddy.ui.pair;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gibuddy.MainActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class PairViewModel extends ViewModel {

  private static final int REQUEST_ENABLE_BT =1 ;
  private MutableLiveData<String> mText;
  //private MutableLiveData<String> dText;
  private BluetoothAdapter bluetoothAdapter;

  public PairViewModel() {
    mText = new MutableLiveData<>();
    //dText = new MutableLiveData<>();
    mText.setValue("Your Connected Device");
    //dText.setValue("Verify that the below device is a GIBuddy");

    setUpBluetoothAdapter();
  }

  public LiveData<String> getText() {
    return mText;

  }

  public void setUpBluetoothAdapter() {




    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (bluetoothAdapter == null) {
      mText.setValue("Your device doesn't support Bluetooth");
    }

    //if (bluetoothAdapter.isEnabled()) {
      //Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
      // line below this doesn't work
      //startBluetoothActivity(enableBluetoothIntent, REQUEST_ENABLE_BT);
        //public static int REQUEST_BLUETOOTH = 1;
        //startActivityForResult(enableBluetoothIntent, REQUEST_BLUETOOTH);

    //}
    Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

    if (pairedDevices.size() > 0) {

      // There are paired devices. Get the name and address of each paired device.
      for (BluetoothDevice device : pairedDevices) {
        String deviceName = device.getName();
        Log.println(Log.ASSERT,"nameofdevice",deviceName);
        String deviceHardwareAddress = device.getAddress(); // MAC address
      }
    }



  }
}