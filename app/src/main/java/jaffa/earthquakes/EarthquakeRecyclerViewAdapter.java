package jaffa.earthquakes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by libby on 12/3/2015.
 */
public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeViewHolder> {

    private Earthquake earthquakes;

    public EarthquakeRecyclerViewAdapter(Earthquake earthquakes){
        this.earthquakes = earthquakes;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.earthquake_list_item, parent, false);

        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EarthquakeViewHolder holder, final int position) {
        holder.bind(earthquakes.getFeatures()[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
            }
        });
    }

    @Override
    public int getItemCount() {
        return earthquakes.getFeatures().length;
    }
}
