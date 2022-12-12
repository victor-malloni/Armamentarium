package br.com.tatudobom.armamentarium.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.model.Obra
import kotlinx.android.synthetic.main.list_item.view.*

/*class ObraAdapter(private val items: List<Obra>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ObraViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is ObraViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ObraViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val obraNome = itemView.TVObra
        private val obraEndereco = itemView.TVEndereco
        private val obraItemQuantidade = itemView.TVItemQuantidade

        fun bind(obra: Obra) {
            obraNome.text = obra.nomeObra
            obraEndereco.text = obra.endereco
            obraItemQuantidade.text = obra.quantidadeFerramentas.toString()
        }

    }

}*/


class ObraAdapter(
    private val context: Context,
    val listener: ObraClickListener
) : RecyclerView.Adapter<ObraAdapter.ObraViewHolder>() {

    class ObraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var obrasLayout = itemView.findViewById<CardView>(R.id.CVObjetoObra)
        var constName = itemView.findViewById<TextView>(R.id.TVObra)
        var constEndereco = itemView.findViewById<TextView>(R.id.TVEndereco)
        var quantityTotal = itemView.findViewById<TextView>(R.id.TVItemQuantidade)
    }

    private val ObraLista = ArrayList<Obra>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObraViewHolder {
        return ObraViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ObraViewHolder, position: Int) {
        val currentObra = ObraLista[position]
        holder.constName.text = currentObra.nomeObra
        holder.constEndereco.text = currentObra.endereco
        holder.quantityTotal.text = currentObra.quantidadeFerramentas.toString()

        holder.obrasLayout.setOnClickListener {
            listener.onItemClicked(ObraLista[holder.adapterPosition])
        }
        holder.obrasLayout.setOnClickListener {
            listener.onLongItemClicked(ObraLista[holder.adapterPosition],holder.obrasLayout)
        }
    }

    override fun getItemCount(): Int {
        return ObraLista.size
    }

    interface ObraClickListener {
        fun onItemClicked(obra: Obra)

        fun onLongItemClicked(obra: Obra, cardView: CardView)

    }


}


