package Java.BlogSite.core.utilities.result;

public class SuccessDataResult<T>  extends DataResult<T>{

	public SuccessDataResult(T data, boolean success) {
		super(data, success);
	}
	
	public SuccessDataResult(T data) {
		super(data,true);
	}
	
	public SuccessDataResult() {
		super(null,true);
	}

}
