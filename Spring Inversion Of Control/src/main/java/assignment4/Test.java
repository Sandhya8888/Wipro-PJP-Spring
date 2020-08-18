package assignment4;

public class Test {
	private String testId;
	private String testTitle;
	private int  testMarks;
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	@Override
	public String toString() {
		return "testId=" + testId + ", testTitle=" + testTitle + ", testMarks=" + testMarks;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public int getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(int testMarks) {
		this.testMarks = testMarks;
	}
}
