package pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import pt.andreiaribeiro.com.andreiaribeiro.R;


public class ServicesDetailFragment extends Fragment {

    public ServicesDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_detail, container, false);

        ImageView serviceDetailPhoto = (ImageView) view.findViewById(R.id.iv_service_image_detail);
        Picasso.with(getActivity()).load("http://casavivaobras.pt/foto-especialidade/canalizacao/trabalhos-de-canalizacao-022.jpg").into(serviceDetailPhoto);
        return view;
    }
}
