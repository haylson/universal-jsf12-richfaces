package br.com.universal.bean;

import java.util.List;
import javax.faces.model.DataModel;

public class PagedListDataModel extends DataModel {
	private int rowIndex = -1;
	private int totalNumRows;
	private int pageSize;
	private List list;

	public PagedListDataModel() {
	}

	public PagedListDataModel(List list, int totalNumRows, int pageSize) {
		setWrappedData(list);
		this.totalNumRows = totalNumRows;
		this.pageSize = pageSize;
	}

	public boolean isRowAvailable() {
		if (this.list == null) {
			return false;
		}
		int rowIndex = getRowIndex();

		return (rowIndex >= 0) && (rowIndex < this.list.size());
	}

	public int getRowCount() {
		return this.totalNumRows;
	}

	public Object getRowData() {
		if (this.list == null)
			return null;
		if (!isRowAvailable()) {
			throw new IllegalArgumentException();
		}
		int dataIndex = getRowIndex();
		return this.list.get(dataIndex);
	}

	public int getRowIndex() {
		return this.rowIndex % this.pageSize;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public Object getWrappedData() {
		return this.list;
	}

	public void setWrappedData(Object list) {
		this.list = ((List) list);
	}
}
