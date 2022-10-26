package br.com.brcarlini.receitatia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.brcarlini.receitatia.R
import br.com.brcarlini.receitatia.model.Postagem

class ListaPostagemAdapter(
    private val context: Context,
    postagens: List<Postagem>
): RecyclerView.Adapter<ListaPostagemAdapter.ViewHolder>() {

    private val postagens = postagens.toMutableList()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun vincula(postagem: Postagem){

            val titulo = itemView.findViewById<TextView>(R.id.title_receita)
            titulo.text = postagem.titulo

            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = postagem.descricao


            val duracao = itemView.findViewById<TextView>(R.id.duracao)
            duracao.text = postagem.duracao
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.card_receita, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val postagem = postagens[position]
        holder.vincula(postagem)
    }

    override fun getItemCount(): Int {
        return postagens.size
    }

    fun atualiza(postagens: List<Postagem>){
        this.postagens.clear()
        this.postagens.addAll(postagens)
        notifyDataSetChanged()
    }

}