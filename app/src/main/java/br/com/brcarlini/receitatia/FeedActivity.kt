package br.com.brcarlini.receitatia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.brcarlini.receitatia.adapter.ListaPostagemAdapter
import br.com.brcarlini.receitatia.dao.PostagensDao
import br.com.brcarlini.receitatia.model.Postagem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Feed : AppCompatActivity(R.layout.activity_feed) {

    private val dao = PostagensDao()
    private val adapter = ListaPostagemAdapter(this, postagens = dao.buscarTodos())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()

    }


    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscarTodos())
    }

    private fun configuraFab(){
        val fab = findViewById<FloatingActionButton>(R.id.fabFeed)
        fab.setOnClickListener {
            irParaForm()
        }
    }

    private fun irParaForm(){
        val intent = Intent(this, FormPostagemActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPostagem)
        recyclerView.adapter = adapter
    }


}