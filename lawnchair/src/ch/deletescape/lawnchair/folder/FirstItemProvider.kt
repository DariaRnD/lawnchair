/*
 *     This file is part of Lawnchair Launcher.
 *
 *     Lawnchair Launcher is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lawnchair Launcher is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lawnchair Launcher.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.deletescape.lawnchair.folder

import com.android.launcher3.model.data.FolderInfo
import com.android.launcher3.model.data.WorkspaceItemInfo

class FirstItemProvider(private val info: FolderInfo) : FolderInfo.FolderListener {

    var firstItem: WorkspaceItemInfo? = findFirstItem()
        private set

    init {
        info.addListener(this)
    }

    private fun findFirstItem() = info.contents.minBy { it.rank }

    override fun onItemsChanged(animate: Boolean) {
        firstItem = findFirstItem()
    }

    override fun onAdd(item: WorkspaceItemInfo?, rank: Int) = Unit
    override fun onRemove(item: WorkspaceItemInfo?) = Unit
}
