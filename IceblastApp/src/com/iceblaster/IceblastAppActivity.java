package com.iceblaster;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.iceblaster.objects.Station;

public class IceblastAppActivity extends Activity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Create the list fragment and add it as our sole content.
		if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
			ArrayListFragment list = new ArrayListFragment();
			getFragmentManager().beginTransaction()
					.add(android.R.id.content, list).commit();
		}

		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				stations.add(new Station());
			}
		});

	}

	private static ArrayList<Station> stations = new ArrayList<Station>();

	public static class ArrayListFragment extends ListFragment {

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			setListAdapter(new ArrayAdapter<Station>(getActivity(),
					android.R.layout.simple_list_item_1,
					(Station[]) stations.toArray()));

		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
			Log.i("FragmentList", "Item clicked: " + id);
		}
	}
}