abstract class WarehouseItem {
    private final String name;

    protected WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getCategory();
}
