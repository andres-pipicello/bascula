/*
 * Copyright (c) 2018. Evren Coşkun
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.github.bascula.tableview.listener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by evrencoskun on 20/09/2017.
 */

public interface ITableViewListener {

    void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int
            row);

    void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, int column, int
            row);

    void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int
            column);

    void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int
            column);

    void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row);

    void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder rowHeaderView, int
            row);


}
