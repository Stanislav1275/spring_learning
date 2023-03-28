package Annotations;

public enum StringsVariants {
    YES("YES"),
    NO("NO");
    private String title;

    StringsVariants(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return title;
    }
}
