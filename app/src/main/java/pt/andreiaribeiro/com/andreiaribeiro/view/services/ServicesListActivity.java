package pt.andreiaribeiro.com.andreiaribeiro.view.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.payments.PaymentsActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ServicesAdapter;

public class ServicesListActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPayments;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);

        Toast.makeText(this, "Welcome to the services screen.", Toast.LENGTH_SHORT).show();

        btnPayments = (Button) findViewById(R.id.button_payments);
        btnPayments.setOnClickListener(this);
        rv = (RecyclerView) findViewById(R.id.rv_services);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        rv.setAdapter(new ServicesAdapter(this, getValidServices()));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PaymentsActivity.class);
        startActivity(intent);
    }

    private List<Service> getValidServices() {
        List<Service> servicesList = new ArrayList<>();

        servicesList.add(new Service("Canalização", "Joao Maria", "10-10-2017",
                "http://casavivaobras.pt/foto-especialidade/canalizacao/trabalhos-de-canalizacao-022.jpg"));
        servicesList.add(new Service("Instalação Software", "Paulo Maria", "20-10-2017",
                "http://netsolutionsny.com/sites/default/files/IT-Guy_5.png"));
        servicesList.add(new Service("Advogado", "Nuno Maria", "10-11-2017",
                "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA1HAAAAJDQzYmQ4YzY2LWI0MzctNDIxYS05Y2ZiLWNkY2JiZGZjNTgzNg.jpg"));
        servicesList.add(new Service("Assistente Pessoal", "Hugo Maria", "01-10-2017",
                "http://imagens1.ne10.uol.com.br/blogsjconline/havagas/2016/07/pa21-700x360.jpg"));
        servicesList.add(new Service("Personal Trainer", "Diogo Maria", "07-11-2017",
                "http://aquadrenalina.com/wp-content/uploads/2016/12/PT2-1024x645.jpg"));
        servicesList.add(new Service("Motorista", "Tomás Maria", "30-10-2017",
                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
        servicesList.add(new Service("Canalização", "Carlos Maria", "30-10-2017",
                "http://casavivaobras.pt/foto-especialidade/canalizacao/trabalhos-de-canalizacao-022.jpg"));
        servicesList.add(new Service("Motorista", "Bernardo Maria", "25-11-2017",
                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
        servicesList.add(new Service("Motorista", "José Maria", "17-11-2017",
                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
        servicesList.add(new Service("Advogado", "Manel Maria", "19-10-2017",
                "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA1HAAAAJDQzYmQ4YzY2LWI0MzctNDIxYS05Y2ZiLWNkY2JiZGZjNTgzNg.jpg"));

        return servicesList;
    }
}
