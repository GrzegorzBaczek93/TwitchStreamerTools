package com.grzegorzbaczek.twitchstreamertools.data.repository.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.v4.graphics.drawable.IconCompat;

import com.grzegorzbaczek.twitchstreamertools.R;

@Entity(tableName = "SocialMediaItems")
public class SocialMediaEntry {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name = "Name placeholder";

    @ColumnInfo(name = "icon_source")
    public int iconSource = R.drawable.ic_twitter_color_icon;
}
