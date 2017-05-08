package fr.unice.polytech.ihmandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

import fr.unice.polytech.ihmandroid.R;
import fr.unice.polytech.ihmandroid.model.Product;
import fr.unice.polytech.ihmandroid.model.Store;

/**
 * Created by MSI on 05/05/2017.
 */

public class StoreDetailedViewFragment extends Fragment {


    private List<Product> products;

    private ImageView storeImage;
    private TextView storeName;
    private TextView storeDescription;
    private TextView storeAdress;
    private TextView storeCityNumber;
    private TextView storeCity;
    private ImageButton storeToProduct;

    public StoreDetailedViewFragment() {

    }

    public static Fragment newInstance(){
        Fragment fragment = new StoreDetailedViewFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.store_detailed_view, container, false);
        findViewById(rootView);
        return rootView;
    }

    private void findViewById(View view){
        storeImage = (ImageView) view.findViewById(R.id.store_image_detailed);
        storeName = (TextView) view.findViewById(R.id.store_name_detailed);
        storeDescription = (TextView) view.findViewById(R.id.store_description_detailed);
        storeAdress = (TextView) view.findViewById(R.id.store_adress_detailed);
        storeCityNumber = (TextView) view.findViewById(R.id.store_cityNumber_detailed);
        storeCity = (TextView) view.findViewById(R.id.store_city_detailed);
        storeToProduct = (ImageButton) view.findViewById(R.id.store_product_button);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        Store store = (Store) bundle.getSerializable("store");

        storeName.setText(store.getName());
        storeDescription.setText(store.getDescription());
        storeAdress.setText(store.getAdress());
        storeCityNumber.setText(store.getCityNumber());
        storeCity.setText(store.getCity());

        Glide.with(this.getContext()).load(store.getImageURL()).placeholder(R.mipmap.store_placeholder).into(storeImage);

    }
}
