package br.edu.fema.forum.ForumFema.utils;

public class CollectionsResponse {
    private Object items;
    private boolean hasNext = false;

    public static CollectionsResponse builder(Object item, boolean hasNext){
        CollectionsResponse cr = new CollectionsResponse();
        cr.items = item;
        cr.hasNext = hasNext;
        return cr;
    }

    public CollectionsResponse() {
    }

    public CollectionsResponse(Object items, boolean hasNext) {
        this.items = items;
        this.hasNext = hasNext;
    }

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
