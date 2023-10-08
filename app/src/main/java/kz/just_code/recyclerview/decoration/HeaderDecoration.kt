package kz.just_code.recyclerview.decoration

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.view.children
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import kz.just_code.recyclerview.CountryListAdapter

class HeaderDecoration : ItemDecoration() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var currentBitmap: Bitmap? = null

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val holders = parent.children
            .map { parent.findContainingViewHolder(it) }
            .filter { it is CountryListAdapter.HeaderViewHolder }

        holders.forEach { it?.itemView?.alpha = 1f }

        val viewHolder = holders.firstOrNull()
        val viewY = viewHolder?.itemView?.y ?: 0f

        if (currentBitmap == null || viewY <= 0 && viewHolder != null) {
            currentBitmap = viewHolder?.itemView?.drawToBitmap()
        }

        val bitmapHeight = currentBitmap?.height ?: 0
        val bitmapOffset = if (viewY > 0 && viewY <= bitmapHeight) viewY - bitmapHeight
        else 0f

        viewHolder?.itemView?.alpha = if (viewY < 0f) 0f else 1f

        currentBitmap?.let {
            c.drawBitmap(it, 16f.dp, bitmapOffset, paint)
        }
    }
}