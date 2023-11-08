package es.studium.misfragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAyuda;
    Button btnAcercaDe;
    FragmentManager fm = getSupportFragmentManager();
    Fragment ayuda;
    Fragment acercaDe;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAyuda = findViewById(R.id.btnAyuda);
        btnAcercaDe = findViewById(R.id.btnAcerca);

        btnAyuda.setOnClickListener(this);
        btnAcercaDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == (R.id.btnAyuda))
        {
            ayuda = fm.findFragmentByTag("ayuda");
            if (ayuda == null)
            {
                Bundle datos = new Bundle();
                datos.putLong("id", 123L);
                datos.putInt("edad", 21);
                datos.putString("nombre", "California");

                Fragment fragmento = new Ayuda();
                fragmento.setArguments(datos);

                ft = fm.beginTransaction();
                ft.replace(R.id.contenedorFragmento, fragmento, "ayuda");
                ft.commit();
            }
        }
        else
        {
            acercaDe = fm.findFragmentByTag("acerca");
            if (acercaDe == null)
            {
                ft = fm.beginTransaction();
                ft.replace(R.id.contenedorFragmento, new AcercaDe(), "acerca");
                ft.commit();
            }
        }
    }
}