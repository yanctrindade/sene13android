package br.com.yimobile.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    //DECLARAR AS VARIÁVEIS DO ARQUIVO XML COM ID
    TextView myTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //RELACIONAR OS ELEMENTOS COM FINDVIEWBYID
        myTxtView = (TextView) findViewById(R.id.second_txtview);

        if (getIntent().getExtras() != null) {
            String emailDoUsuario = getIntent().getStringExtra("emailDoUsuario");
            //ALTERAR O CONTEÚDO DO TEXTVIEW PARA O EMAIL DO USUÁRIO
            myTxtView.setText(emailDoUsuario);
        }

    }

    @Override
    public void onBackPressed() {
        //nada-faz
    }
}
