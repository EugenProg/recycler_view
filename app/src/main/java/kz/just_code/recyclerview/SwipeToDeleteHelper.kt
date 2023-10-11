package kz.just_code.recyclerview

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.recyclerview.decoration.dp

fun RecyclerView.swipeToDelete(deleteAction: (Int) -> Unit) {
    ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START) {
        val rectangleLength = 97.dp
        val maxScroll = 80.dp
        val image = BitmapFactory.decodeResource(resources, R.drawable.ic_chat_list_delete)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (viewHolder is CountryListAdapter.CountryViewHolder) {
                context.vibratePhone()
                deleteAction.invoke(viewHolder.adapterPosition)
            }
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            if (viewHolder is CountryListAdapter.CountryViewHolder &&
                actionState == ItemTouchHelper.ACTION_STATE_SWIPE
            ) {
                with(viewHolder.itemView) {
                    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                    val scrollOffset = (-dX).toInt()

                    if (scrollOffset > 10) {
                        paint.color = ContextCompat.getColor(context, R.color.red)
                        val back = RectF(
                            right.toFloat() - rectangleLength,
                            top.toFloat(),
                            right.toFloat(),
                            bottom.toFloat()
                        )
                        c.drawRect(back, paint)
                    }

                    if (scrollOffset < maxScroll) {
                        super.onChildDraw(
                            c,
                            recyclerView,
                            viewHolder,
                            -scrollOffset.toFloat(),
                            dY,
                            actionState,
                            isCurrentlyActive
                        )
                    }

                    if (scrollOffset > 50.dp) {
                        val iconRect = RectF(
                            right.toFloat() - 50.dp,
                            top.toFloat() + 28.dp,
                            right.toFloat() - 30.dp,
                            bottom.toFloat() - 30.dp
                        )
                        c.drawBitmap(image, null, iconRect, paint)
                    }
                }
            }
        }

    }).attachToRecyclerView(this)
}

fun Context.vibratePhone() {
    val vibration = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        vibration.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibration.vibrate(100)
    }
}