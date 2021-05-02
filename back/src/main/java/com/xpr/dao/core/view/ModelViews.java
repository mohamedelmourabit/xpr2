package com.xpr.dao.core.view;



public class ModelViews {
	
   public static class SelectView {
    };

	public static class ListView extends SelectView {
	};
	
	public static class PartialFullView extends ListView{
	};
	
	public static class FullView extends  PartialFullView {
	};

}
