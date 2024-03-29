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

package com.github.bascula.tableview.adapter.recyclerview.holder;

import android.view.View;

import com.github.bascula.tableview.sort.SortState;

/**
 * Created by evrencoskun on 16.12.2017.
 */

public class AbstractSorterViewHolder extends AbstractViewHolder {

    private SortState mSortState = SortState.UNSORTED;

    public AbstractSorterViewHolder(View itemView) {
        super(itemView);
    }

    public void onSortingStatusChanged(SortState pSortState) {
        this.mSortState = pSortState;
    }

    public SortState getSortState() {
        return mSortState;
    }
}
