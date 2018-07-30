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
    public String name = "";

    @ColumnInfo(name = "icon_source")
    public String iconSource = "";

    @ColumnInfo(name = "last_message")
    public String lastMessage = "";
}
