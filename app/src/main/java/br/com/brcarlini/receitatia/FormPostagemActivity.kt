package br.com.brcarlini.receitatia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import br.com.brcarlini.receitatia.dao.PostagensDao
import br.com.brcarlini.receitatia.model.Postagem

class FormPostagemActivity : AppCompatActivity(R.layout.activity_form_postagem) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configurarBotaoCriar()
        configurarBotaoVoltar()

    }



    private fun configurarBotaoCriar(){
        val buttonCriar = findViewById<Button>(R.id.buttonCriarPost)
        val dao = PostagensDao()

        buttonCriar.setOnClickListener {
            val postagemNova = criaPostagem()
            dao.adicionar(postagemNova)
            finish()
        }
    }

    private fun irParaFeed(){
        val intent = Intent(this, Feed::class.java)
        startActivity(intent)
    }

    private fun configurarBotaoVoltar(){
        val buttonBack = findViewById<ImageButton>(R.id.buttonBackForm)

        buttonBack.setOnClickListener {
            irParaFeed()
        }
    }



    private fun criaPostagem(): Postagem{

        val campoTitulo = findViewById<EditText>(R.id.title_post)
        val titulo = campoTitulo.text.toString()

        val campoDescricao = findViewById<EditText>(R.id.descricao_post)
        val descricao = "Descrição: ${campoDescricao.text.toString()}"

        val campoDuracao = findViewById<EditText>(R.id.duracao_post)
        val duracao = "Duração de preparo: ${campoDuracao.text.toString()}"



        return Postagem(
            titulo = titulo,
            descricao = descricao,
            duracao = duracao
        )
    }

}