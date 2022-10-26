package br.com.brcarlini.receitatia.dao

import br.com.brcarlini.receitatia.model.Postagem

class PostagensDao {

    companion object {
        private val postagens = mutableListOf<Postagem>()
    }

    fun adicionar(postagem: Postagem){
        postagens.add(postagem)
    }

    fun buscarTodos(): List<Postagem> {
        return postagens.toList()
    }

}