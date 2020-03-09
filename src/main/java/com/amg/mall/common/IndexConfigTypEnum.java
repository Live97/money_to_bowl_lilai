package com.amg.mall.common;

/**
 *	首先配置项 1-搜索框热搜 2-搜索下拉框热搜 3-首页热销商品 4-新品上线 5-为你推荐
 */
public enum IndexConfigTypEnum {
	
	DEFAULT(0,"DEFAULT"),
	INDEX_SEARCH_HOTS(1,"INDEX_SEARCH_HOTS"),
	INDEX_SEARCH_DOWN_HOTS(2,"INDEX_SEARCH_DOWN_HOTS"),
	INDEX_GOODS_HOT(3,"INDEX_GOODS_HOT"),
	INDEX_GOODS_NEW(4,"INDEX_GOODS_NEW"),
	INDEX_GOODS_RECOMMOND(5,"INDEX_GOODS_RECOMMOND");
	
	private int type;
	
	private String name;
	
	IndexConfigTypEnum(int type ,String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * 直接提供一个静态方法获取到对应的类型
	 * @param type
	 * @return
	 */
	public static IndexConfigTypEnum getIndexConfigType(int type){
		for (IndexConfigTypEnum value : IndexConfigTypEnum.values()) {
			if (value.getType() == type) {
				return value;
			}
		}
		return DEFAULT;
	}
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
