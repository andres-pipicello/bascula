package com.github.bascula.tableview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.github.bascula.tableview.adapter.AbstractTableAdapter
import com.github.bascula.tableview.adapter.recyclerview.holder.AbstractViewHolder

private typealias AVH = AbstractViewHolder

object Adapter {
    interface Header<Model, Holder : AVH> {

        fun bind(holder: Holder, model: Model, position: Int)

        fun create(parent: ViewGroup, viewType: Int): Holder

        fun type(position: Int): Int
    }
}



interface Content<Model, Holder : AVH> {

    fun bind(holder: Holder, model: Model, column: Int, row: Int)

    fun create(parent: ViewGroup, viewType: Int): Holder

    fun type(position: Int): Int
}

open class Holder<T : View>(view: T) : AbstractViewHolder(view) {
    val view
        get() = super.itemView as T
}

inline fun <reified Column, reified Row, reified Cell, reified ColumnHolder : AVH, reified RowHolder : AVH, reified CellHolder : AVH> adapter(
    column: Adapter.Header<Column, ColumnHolder>,
    row: Adapter.Header<Row, RowHolder>,
    cell: Content<Cell, CellHolder>,
    crossinline cornerFactory: () -> View,
    context: Context
): AbstractTableAdapter<Column, Row, Cell> {

    return object : AbstractTableAdapter<Column, Row, Cell>(context) {

        override fun onCreateColumnHeaderViewHolder(parent: ViewGroup?, viewType: Int) =
            column.create(parent!!, viewType)

        override fun onBindColumnHeaderViewHolder(
            holder: AVH?,
            columnHeaderItemModel: Any?,
            columnPosition: Int
        ) = column.bind(holder as ColumnHolder, columnHeaderItemModel as Column, columnPosition)

        override fun onBindRowHeaderViewHolder(
            holder: AVH?,
            rowHeaderItemModel: Any?,
            rowPosition: Int
        ) = row.bind(holder as RowHolder, rowHeaderItemModel as Row, rowPosition)

        override fun onCreateRowHeaderViewHolder(parent: ViewGroup?, viewType: Int) =
            row.create(parent!!, viewType)

        override fun getCellItemViewType(position: Int) = cell.type(position)

        override fun onCreateCellViewHolder(parent: ViewGroup?, viewType: Int): AVH = cell.create(parent!!, viewType)

        override fun onCreateCornerView() = cornerFactory.invoke()

        override fun onBindCellViewHolder(
            holder: AVH?,
            cellItemModel: Any?,
            columnPosition: Int,
            rowPosition: Int
        ) {
            cell.bind(holder as CellHolder, cellItemModel as Cell, columnPosition, rowPosition)
        }

        override fun getColumnHeaderItemViewType(position: Int) = column.type(position)

        override fun getRowHeaderItemViewType(position: Int) = column.type(position)

    }

}