// Mithel Almeida Medeiros - 00101512

package com.aula2.toca_do_coelho;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TocaDoCoelho extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButRegis(View view){
        TextView adicionarPedido = (TextView) findViewById(R.id.texto);                                                 //Linha de código que linka o campo de texto com o clique do botão

        adicionarPedido.setText("Registrando Pedido");                                                                  //Reescrevendo o conteúdo do campa de texto
    }

    public void onClickButConsul(View view){
        TextView consultaHoras = (TextView) findViewById(R.id.texto);

        consultaHoras.setText("Total de Horas");
    }

    public void onClickButPedido(View view){
        Intent intent = new Intent(this, PedidoAtendente.class);

        startActivity(intent);
    }

}