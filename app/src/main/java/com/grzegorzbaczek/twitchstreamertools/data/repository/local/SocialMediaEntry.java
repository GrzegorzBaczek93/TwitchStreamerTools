package com.grzegorzbaczek.twitchstreamertools.data.repository.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "SocialMediaItems")
public class SocialMediaEntry {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name = "data loading error";

    @ColumnInfo(name = "icon_source")
    public String iconSource = "data loading error";

    @ColumnInfo(name = "last_message")
    public String lastMessage = "data loading error";
}
