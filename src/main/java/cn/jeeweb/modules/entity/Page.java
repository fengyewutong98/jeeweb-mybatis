package cn.jeeweb.modules.entity;


import java.io.Serializable;
import java.util.List;


/**
 * 分页数据类
 * @author luosl_wb
 *
 */
public class Page<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 默认每页记录数
	 */
	public static final int PAGE_SIZE = 10;

	/**
	 * 每页记录数
	 */
	private int pageSize = PAGE_SIZE;
	/**
	 * 总记录数
	 */
	private int total;
	/**
	 * 显示的数据
	 */
	private List<E> data;
	
	public Page() {
	}

	public Page(int total, List<E> data) {
		this.total = total;
		this.data = data;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

}
