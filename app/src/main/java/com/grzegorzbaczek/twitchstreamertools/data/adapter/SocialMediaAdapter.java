package com.grzegorzbaczek.twitchstreamertools.data.adapter;

import com.grzegorzbaczek.twitchstreamertools.data.repository.local.SocialMediaEntry;

import java.util.Collections;
import java.util.List;

public class SocialMediaAdapter extends SingleLayoutAdapter {

    private List<SocialMediaEntry> entryList = Collections.emptyList();

    public SocialMediaAdapter(int layoutId) {
        super(layoutId);
    }

    @Override
    protected Object getObjForPosition(int position) {
        return entryList.get(position);
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }

    public void setData(List<SocialMediaEntry> entryList) {
        this.entryList = entryList;
        notifyDataSetChanged();
    }
}
