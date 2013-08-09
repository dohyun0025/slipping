package net.slipp.service.content;

public class OwnerNotEqualException extends Exception {
	private static final long serialVersionUID = -124944399687435182L;

	@Override
	public String getMessage() {
		return "글 수정 권한이 없습니다.";
	}
}
