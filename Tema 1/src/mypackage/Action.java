package mypackage;

import fileio.ActionInputData;

import java.util.List;

public final class Action {

    private List<ActionInputData> actions;

    public Action(final List<ActionInputData> actions) {
        this.actions = actions;
    }

    public List<ActionInputData> getActions() {
        return actions;
    }

    public void setActions(final List<ActionInputData> actions) {
        this.actions = actions;
    }
}
