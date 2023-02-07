package com.common.model.vo;

public class PageInfo {
	// PageInfo class field
	private int listCount; // ���� �� �Խñ� ����
	private int currentPage; // ���� ������(��,����ڰ� ��û�� ������)
	private int pageLimit = 10; // ������ �ϴܿ� ������ ����¡���� ������ �ִ� ����
	private int boardLimit = 10; // �� �������� ������ �Խñ��� �ִ� ���� (� ������ ����������)
	private int maxPage; // ���� ������ �������� ��������� ���� (�� ������ ��)
	private int startPage; // ������ �ϴܿ� ������ ����¡���� ���ۼ�
	private int endPage; // ������ �ϴܿ� ������ ����¡���� ����
	// PageInfo class method
	// ������ �������� ���� �Խñ��� ROWNUM ��ȯ method
	public int startBoard() {
		int startBoard = 0;
		if (currentPage == 1) {
			return 1;
		} else {
			startBoard = boardLimit * (currentPage - 1) + 1;
		}
		return startBoard;
	}

	// ������ �������� ������ �Խñ��� ROWNUM ��ȯ method
	public int endBoard() {
		int endBoard = boardLimit * currentPage;
		
		if (endBoard > listCount) {
			return listCount;
		}
		
		return endBoard;
	}

	// PageInfo class toString
	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}

	// PageInfo class constructor
	// �Խñ��� ������ ���� �Խ��� ��ȣ�� �޴� ������
	public PageInfo(int listCount, int currentPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		if (pageLimit>=currentPage) {
			startPage = 1;
		}else {
			for (int i = 1; i < (int) Math.ceil((double) maxPage / pageLimit); i++) {
				if ((int) Math.pow(pageLimit, i + 1) >= currentPage) {
					startPage = (int) Math.pow(pageLimit, i)+1;
					break;
				}
			}
		}
		endPage = startPage + pageLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
	}
	

	public PageInfo(int listCount, int currentPage, int boardLimit) {
		super();
		this.boardLimit = boardLimit;
		this.listCount = listCount;
		this.currentPage = currentPage;
		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		if (pageLimit>=currentPage) {
			startPage = 1;
		}else {
			for (int i = 1; i < (int) Math.ceil((double) maxPage / pageLimit); i++) {
				if ((int) Math.pow(pageLimit, i + 1) >= currentPage) {
					startPage = (int) Math.pow(pageLimit, i)+1;
					break;
				}
			}
		}
		endPage = startPage + pageLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
	}

	public PageInfo() {
		super();
	}

	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	// Attachment class getter/setter

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
