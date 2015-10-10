package net.sanclemente.a14felipecm.u3_i_a14felipecm_dialogos;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by felipe on 10/10/15.
 */
public class U3_I_Dialogos_Fragment extends DialogFragment {


    private static final int DIALOGO_MENSAXE = 1;
    private static final int DIALOGO_TRES_BOTONS = 2;
    private static final int DIALOGO_LISTA = 3;
    private static final int DIALOGO_RADIO_BUTTON = 4;
    private static final int DIALOGO_CHECK_BOX = 5;
    private static final int DIALOGO_ENTRADA_TEXTO = 6;


    public Dialog onCreateDialog(Bundle estado) {
        AlertDialog.Builder dialogo;
        int id = getArguments().getInt("ide");
        switch (id) {

            case DIALOGO_MENSAXE:
                dialogo = new AlertDialog.Builder(getActivity());
                dialogo.setTitle("Atención");
                dialogo.setMessage("Nova amensaxe. Preme o botón 'Back' para volver á pantalla principal");
                dialogo.setIcon(android.R.drawable.ic_dialog_email);
                return dialogo.create();



            case DIALOGO_TRES_BOTONS:
                dialogo = new AlertDialog.Builder(getActivity());
                dialogo.setIcon(android.R.drawable.ic_dialog_info);
                dialogo.setTitle("Enquisa");
                dialogo.setMessage("Compras sempre en grandes superficies?");
                dialogo.setCancelable(false);
                dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Si */
                        Toast.makeText(getActivity(), "Premeches 'Si'", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Non */
                        Toast.makeText(getActivity(), "Premeches'Non'", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.setNeutralButton("Ás veces", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                                        /* Sentencias se o usuario preme Ás veces */
                        Toast.makeText(getActivity(), "Premeches 'Ás veces'", Toast.LENGTH_SHORT).show();
                    }
                });
                return dialogo.create();



            case DIALOGO_LISTA:
                dialogo = new AlertDialog.Builder(getActivity());
                dialogo.setIcon(android.R.drawable.ic_dialog_alert);
                dialogo.setTitle("Escolle unha opción");
                dialogo.setItems(R.array.elementos_dialog_seleccion, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int opcion) {
                        // O usuario selecciona unha das opcións do listado
                        String[] opcions = getResources().getStringArray(R.array.elementos_dialog_seleccion);
                        Toast.makeText(getActivity(), "Seleccionaches: '" + opcions[opcion] + "'", Toast.LENGTH_SHORT).show();
                    }
                });
                return dialogo.create();



            case DIALOGO_RADIO_BUTTON:
                dialogo = new AlertDialog.Builder(getActivity());
                dialogo.setIcon(android.R.drawable.ic_dialog_info);
                dialogo.setTitle("Selecciona un smartpohone");
                // Non incluír mensaxe dentro de este tipo de diálogo!!!
                final CharSequence[] smartphones = { "iPhone", "Blackberry", "Android" };
                dialogo.setSingleChoiceItems(smartphones, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int opcion) {
                        // Evento que ocorre cando o usuario selecciona una opción
                        Toast.makeText(getActivity(), "Seleccionaches: " + smartphones[opcion], Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Premeches 'Aceptar'", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                return dialogo.create();



            case DIALOGO_CHECK_BOX:
                dialogo = new AlertDialog.Builder(getActivity());
                dialogo.setIcon(android.R.drawable.ic_dialog_info);
                dialogo.setTitle("Selecciona modos de transporte");
                Resources res = getResources();
                final String[] matriz = res.getStringArray(R.array.elementos_dialog_seleccion2);
                // Non incluír mensaxe dentro de este tipo de diálogo!!!
                dialogo.setMultiChoiceItems(matriz, new boolean[] { false, true, false, true, false, false, false }, new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int opcion, boolean isChecked) {
                        // Evento que ocorre cando o usuario selecciona unha opción
                        if (isChecked)
                            Toast.makeText(getActivity(), "Seleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "Deseleccionaches " + matriz[opcion], Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Premches 'Aceptar'", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                return dialogo.create();



            case DIALOGO_ENTRADA_TEXTO:
                // Primeiro preparamos o interior da ventá de diálogo inflando o seu
                // fichero XML
                String infService = Context.LAYOUT_INFLATER_SERVICE;
                LayoutInflater li = (LayoutInflater) getActivity().getSystemService(infService);
                // Inflamos o compoñente composto definido no XML
                View inflador = li.inflate(R.layout.dialogo_entrada_texto, null);
                // Buscamos os compoñentes dentro do Diálogo
                final TextView etNome = (TextView) inflador.findViewById(R.id.et_nome);
                final TextView etContrasinal = (TextView) inflador.findViewById(R.id.et_contrasinal);

                dialogo = new AlertDialog.Builder(getActivity());
                dialogo.setTitle("Indica usuario e contrasinal");
                // Asignamos o contido dentro do diálogo (o que inflamos antes)
                dialogo.setView(inflador);
                // Non se pode incluír unha mensaxe dentro deste tipo de diálogo!!!
                dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Escribiches nome: '" + etNome.getText().toString() + "'. Contrasinal: '" + etContrasinal.getText().toString() + "' e premeches 'Aceptar'",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int boton) {
                        Toast.makeText(getActivity(), "Premeches en 'Cancelar'", Toast.LENGTH_SHORT).show();
                    }
                });
                return dialogo.create();

        }
        return null;
    }



}
