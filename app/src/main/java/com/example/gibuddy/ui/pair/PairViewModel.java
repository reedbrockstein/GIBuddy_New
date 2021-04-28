package com.example.gibuddy.ui.pair;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.snackbar.Snackbar;

import static androidx.core.app.ActivityCompat.startActivityForResult;

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

  public void setUpBluetoothAdapter() {

    // Displays toast to open settings to pair there
    /*
    Context context = getApplicationContext();
    CharSequence text = "Please open Settings to pair your GIBuddy there!";
    int duration = Toast.LENGTH_SHORT;

    Toast toast = Toast.makeText(context, text, duration);
    toast.show();

    Snackbar mySnackbar = Snackbar.make(view, stringId, duration).show();

     */


    /*
    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (bluetoothAdapter == null) {
      mText.setValue("Your device doesn't support Bluetooth");
    }

    if (bluetoothAdapter.isEnabled()) {
      Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
      // line below this doesn't work
//      startBluetoothActivity(enableBluetoothIntent, REQUEST_ENABLE_BT);
      // modification of the line above
        //public static int REQUEST_BLUETOOTH = 1;
        //startActivityForResult(enableBluetoothIntent, REQUEST_BLUETOOTH);

    }

     */

  }
}