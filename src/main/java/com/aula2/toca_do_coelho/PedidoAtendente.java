package com.aula2.toca_do_coelho;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PedidoAtendente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_atendente);
    }

    public void onEnviarPedido (View view){
        Log.d("View", "Classe que está sendo passada" + view.getClass());

        EditText viewPedido = (EditText) findViewById(R.id.sendPedido);
        String textoPedido = viewPedido.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/pl");

        intent.putExtra(Intent.EXTRA_TEXT, textoPedido);

        startActivity(intent);
    }

}