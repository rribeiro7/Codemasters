package pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.Professional;


public class ServicesDetailFragment extends Fragment {

    private TextView txtTitle, txtActivity, txtDateBirth, txtDescription, txtEmail, txtExperience, txtFormation, txtLocation, txtService;

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

    private void setLayout(View view){
        txtTitle = (TextView)view.findViewById(R.id.details_txtTitle);
        txtActivity = (TextView)view.findViewById(R.id.details_txtActivity);
        txtDateBirth = (TextView)view.findViewById(R.id.details_txtDateBirth);
        txtDescription = (TextView)view.findViewById(R.id.details_txtDescription);
        txtEmail = (TextView)view.findViewById(R.id.details_txtEmail);
        txtExperience = (TextView)view.findViewById(R.id.details_txtExperience);
        txtFormation = (TextView)view.findViewById(R.id.details_txtFormation);
        txtLocation = (TextView)view.findViewById(R.id.details_txtLocation);
        txtService = (TextView)view.findViewById(R.id.details_txtService);
    }

    private void loadData(Professional prof){
        txtTitle.setText(prof.getName());
        txtDateBirth.setText(prof.getBirthdate());
        txtDescription.setText(prof.getDescription());
        txtEmail.setText(prof.getEmail());
        txtExperience.setText(prof.getExperience());
        txtFormation.setText(prof.getFormation());
        txtLocation.setText(prof.getGeoThree().getValue());

        txtActivity.setText("");
        txtService.setText("");
    }
}
