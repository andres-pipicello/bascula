package com.github.bascula.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.github.bascula.tableview.TableView
import com.github.bascula.presistence.Database
import com.github.bascula.R
import com.github.bascula.tableview.Adapter
import com.github.bascula.tableview.Content
import com.github.bascula.tableview.Holder
import com.github.bascula.tableview.adapter

class TableFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.table_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        require(view is  TableView)
        class ColumnHolder : Holder<TextView>(TextView(context))

        class RowHolder : Holder<TextView>(TextView(context))

        class CellHolder : Holder<TextView>(TextView(context))

        class ColumnModel
        class RowModel
        class CellModel

        val adapter = adapter(
            object : Adapter.Header<ColumnModel, ColumnHolder> {
                override fun bind(holder: ColumnHolder, model: ColumnModel, position: Int) {
                    holder.view.text = "column $position"
                }

                override fun create(parent: ViewGroup, viewType: Int) = ColumnHolder()

                override fun type(position: Int) = 0

            },
            object : Adapter.Header<RowModel, RowHolder> {
                override fun bind(holder: RowHolder, model: RowModel, position: Int) {
                    holder.view.text = "row $position"
                }

                override fun create(parent: ViewGroup, viewType: Int): RowHolder = RowHolder()

                override fun type(position: Int) = 0

            },
            object : Content<CellModel, CellHolder> {
                override fun bind(holder: CellHolder, model: CellModel, column: Int, row: Int) {
                    (holder.itemView as TextView).apply { text = "cell $column, $row" }
                }

                override fun create(parent: ViewGroup, viewType: Int) = CellHolder()

                override fun type(position: Int) = 0

            },
            { ViewStub(context!!) },
            context!!
        )
        view.adapter = adapter
        adapter.setAllItems(
            mutableListOf(ColumnModel(), ColumnModel(), ColumnModel()),
            mutableListOf(RowModel(), RowModel(), RowModel(), RowModel(), RowModel(), RowModel()),
            mutableListOf(
                mutableListOf(CellModel(), CellModel(), CellModel()),
                mutableListOf(CellModel(), CellModel(), CellModel()),
                mutableListOf(CellModel(), CellModel(), CellModel()),
                mutableListOf(CellModel(), CellModel(), CellModel()),
                mutableListOf(CellModel(), CellModel(), CellModel()),
                mutableListOf(CellModel(), CellModel(), CellModel())
            )
        )
        val db = Room.databaseBuilder(
            context!!,
            Database::class.java, "database-name"
        ).build()
    }
}