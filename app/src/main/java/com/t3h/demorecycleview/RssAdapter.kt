package com.t3h.demorecycleview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.t3h.demorecycleview.databinding.ItemRssBinding


class RssAdapter : RecyclerView.Adapter<RssAdapter.RssViewHolder> {
    private var rssDatas: MutableList<RssData>
    constructor(rssDatas: MutableList<RssData>) {
        this.rssDatas = rssDatas
    }

    //tao viewholder
    override fun onCreateViewHolder(group: ViewGroup, type: Int): RssViewHolder {
        val binding=ItemRssBinding.inflate(
                LayoutInflater.from(group.context),
                group,
                false
                )
        binding.root
        //lay context tu group vi
        //+ tat ca cac loai view deu co context
        // +vi co context moi hien thi duoc
//        val itemView = LayoutInflater.from(group.context).inflate(
//                R.layout.item_rss, group, false
//        )
        return RssViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rssDatas.size
    }

    //do du lieu len itemview(viewholder)
    override fun onBindViewHolder(holder: RssViewHolder, position: Int) {
        val data = rssDatas.get(position)
        holder.binding.itemData= data
        if ( rssDatas.get(position).isOnClick){
            holder.itemView.setBackgroundColor(Color.BLUE)
        }else{holder.itemView.setBackgroundColor(Color.WHITE)}
        //holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener({
            rssDatas.get(position).isOnClick = !rssDatas.get(position).isOnClick
            notifyItemChanged(position)
        })
//        holder.binding.tvTitle.text= data.title
//        holder.binding.tvDescription.text= data.description
     //Glide.with(holder.binding.ivImg).load(data.img).placeholder(R.drawable.aodai).error(R.drawable.aodai).into(holder.binding.ivImg)

//        holder.tvTitle.text = data.title
//        holder.tvDesciption.text = data.description
//
//        Glide.with(holder.ivImg)
//                .load(data.img)
//                .placeholder(R.drawable.aodai)
//                .error(R.drawable.aodai)
//                .into(holder.ivImg)
    }

    class RssViewHolder : RecyclerView.ViewHolder {
        val binding:ItemRssBinding
        constructor(binding:ItemRssBinding):super(binding.root){
            this.binding = binding
        }
//        var ivImg: ImageView
//        var tvTitle: TextView
//        var tvDesciption: TextView
//
//        init {
//            ivImg = itemView.findViewById(R.id.iv_img)
//            tvTitle = itemView.findViewById(R.id.tv_title)
//            tvDesciption = itemView.findViewById(R.id.tv_description)
//        }
    }
}
