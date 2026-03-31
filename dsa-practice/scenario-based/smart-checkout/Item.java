class Item{
	String name;
	
	Item( String name ){
		this.name = name;
	}
	
	@Override
	public boolean equals( Object o ) {
		if(this == o ) return true;
		
		if( !( o instanceof Item)) return false;
		
		Item item = (Item)o;
		
		return name.equals(item.name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}