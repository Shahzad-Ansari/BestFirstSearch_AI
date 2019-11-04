class SearchResult {
	public enum SearchOutcome {
		FAILURE, SOLUTION_FOUND
	};

	private node solution;

	private SearchOutcome outcome;

	private final int fCostLimit;

	public SearchResult(node solution, int fCostLimit) {
		if (null == solution) {
			this.outcome = SearchOutcome.FAILURE;
		} else {
			this.outcome = SearchOutcome.SOLUTION_FOUND;
			this.solution = solution;
		}
		this.fCostLimit = fCostLimit;
	}

	public SearchOutcome getOutcome() {
		return outcome;
	}

	public node getSolution() {
		return solution;
	}

	public int getFCostLimit() {
		return fCostLimit;
	}
}