package br.com.yimobile.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DECLARAR AS VARIÁVEIS que possuem ID' do arquivo XML
    //TEXTVIEW
    TextView emailTextView;
    TextView senhaTextView;

    //EDITTEXT
    EditText emailEditText;
    EditText senhaEditText;

    //BOTÃO
    Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperar os elementos usando a função findViewById
        emailTextView = (TextView) findViewById(R.id.main_email_txtview);
        senhaTextView = (TextView) findViewById(R.id.main_senha_txtview);
        emailEditText = (EditText) findViewById(R.id.main_email_editxt);
        senhaEditText = (EditText) findViewById(R.id.main_senha_edittxt);
        botaoLogin = (Button) findViewById(R.id.main_botao_login);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. recuperar conteúdo dos campos editText
                String email = emailEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                //2. verificar se há campo em branco
                if (email.length() == 0 || senha.length() == 0) {
                    //o campo está em branco
                    //Log.e("TELA DE LOGIN", "EM BRANCOOO");
                    //TOAST É O ELEMENTO QUE INFORMA O USUÁRIO
                    Toast.makeText(getApplicationContext(), "HÁ CAMPOS EM BRANCO !!!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //3. verificar se login e senha são corretos
                if (email.equalsIgnoreCase("y@yi.com")
                        && senha.equalsIgnoreCase("senha")) {
                    //Log.e("TELA DE LOGIN", "SENHA E MAIL CORRETOS !!!!");
                    Toast.makeText(getApplicationContext(), "USUÁRIO LOGADO !!!!!", Toast.LENGTH_SHORT).show();

                    //IR PARA A PRÓXIMA TELA ...
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    //PRIMEIRO PARÂMETRO É UM IDENTIFICADOR, O SEGUNDO É O CONTEÚDO A SER PASSADO
                    intent.putExtra("emailDoUsuario", email);
                    startActivity(intent);

                } else {
                    //ESTÃO INVÁLIDOS ...
                    senhaEditText.setText("");
                    Toast.makeText(getApplicationContext(), "SENHA OU MAIL ERRADOS !!!", Toast.LENGTH_SHORT).show();
                    //Log.e("TELA DE LOGIN", "SENHA E MAIL ERRADOS !!!");
                }
            }
        });

    }


}
