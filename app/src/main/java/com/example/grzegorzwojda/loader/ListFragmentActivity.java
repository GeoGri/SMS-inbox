package com.example.grzegorzwojda.loader;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Grzegorz Wojda on 2016-01-08.
 */
public class ListFragmentActivity extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public final int LOADER_ID = 0;
    LoaderAdapter lAdapter;
    public final Uri URI = Uri.parse("content://sms/inbox");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lAdapter = new LoaderAdapter(getActivity(), null);
        setListAdapter(lAdapter);
        getLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),URI,null, null, null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        lAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        lAdapter.swapCursor(null);
    }
}
