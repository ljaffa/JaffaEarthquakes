package jaffa.earthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by libby on 12/3/2015.
 */
    public class EarthquakeViewHolder extends RecyclerView.ViewHolder{
        private TextView magnitude;
        private TextView place;
        /**itemView is the president_list_item that was created.
         * the entire row that contains the textview with the presidents name
         */
        public EarthquakeViewHolder(View itemView){
            super(itemView);
            magnitude = (TextView) itemView.findViewById(R.id.mag);
            place = (TextView) itemView.findViewById(R.id.place);
        }

        public void bind(Feature feature){
            magnitude.setText(String.valueOf(feature.getProperties().getMag()));
            place.setText(feature.getProperties().getPlace());

    }

}
