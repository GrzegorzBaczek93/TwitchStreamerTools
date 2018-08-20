package com.grzegorzbaczek.twitchstreamertools.ui.message;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.net.Uri;

public class MessageViewModel extends ViewModel {

    public ObservableField<Uri> imageData = new ObservableField<>();

    public void resetImageData() {
        imageData.set(null);
    }

    @Override
    public String toString() {
        return imageData.get().getLastPathSegment();
    }
}
