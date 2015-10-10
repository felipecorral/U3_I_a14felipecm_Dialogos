package net.sanclemente.a14felipecm.u3_i_a14felipecm_dialogos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class U3_I_Dialogos extends FragmentActivity {

    private static final int DIALOGO_MENSAXE = 1;
    private static final int DIALOGO_TRES_BOTONS = 2;
    private static final int DIALOGO_LISTA = 3;
    private static final int DIALOGO_RADIO_BUTTON = 4;
    private static final int DIALOGO_CHECK_BOX = 5;
    private static final int DIALOGO_ENTRADA_TEXTO = 6;

    private U3_I_Dialogos_Fragment dialog_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3__i__dialogos);
        dialog_fragment = new U3_I_Dialogos_Fragment();
    }


    public void onBotonClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        //Creo el bundle con los datos necesarios para llamar al fragment
        Bundle args =new Bundle();
        //Con un case, meto en el bundle el int que me interesa
        switch (view.getId()) {
            case R.id.btn_dialogo:
                args.putInt("ide", DIALOGO_MENSAXE);
                break;

            case R.id.btn_diag_tres_botons:
                args.putInt("ide", DIALOGO_TRES_BOTONS);
                break;

            case R.id.btn_diag_list_selecc:
                args.putInt("ide",DIALOGO_LISTA);
                break;

            case R.id.btn_diag_radio_button:
                args.putInt("ide",DIALOGO_RADIO_BUTTON);
                break;

            case R.id.btn_diag_checkbox:
                args.putInt("ide",DIALOGO_CHECK_BOX);
                break;

            case R.id.btn_diag_entrada_texto:
                args.putInt("ide",DIALOGO_ENTRADA_TEXTO);
                break;

            default:
                break;
        }
        //Paso el bundle al dialogFragment
        dialog_fragment.setArguments(args);
        dialog_fragment.show(fm, "");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u3__i__dialogos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
