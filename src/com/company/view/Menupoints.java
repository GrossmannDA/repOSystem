package com.company.view;

public enum Menupoints {

    CREATE_NEW_BOARD("1. Create new board", 1),
    CREATE_NEW_LIST("2. Create new list", 2),
    CREATE_NEW_CARD("3. Create new card", 3),
    END("999. End", 999);

    private final String menupoint;
    private final int action;

    Menupoints(String menupoint, int action) {

        this.menupoint = menupoint;
        this.action=action;
    }

    public String getMenupoint() {
        return this.menupoint;
    }

    public int getAction() {
        return this.action;
    }
}
