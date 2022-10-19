package mypackage;

import fileio.ActionInputData;
import fileio.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Actions.
 */
public final class Actions {

    private Input actionInput;
    private List<ActionInputData> commands = new ArrayList<>();
    private List<ActionInputData> queries = new ArrayList<>();
    private List<ActionInputData> recommendations = new ArrayList<>();
    private List<ActionInputData> actions = new ArrayList<>();

    /**
     * Instantiates a new Actions.
     *
     * @param actionInput the action input
     */
    public Actions(final Input actionInput) {
        this.actionInput = actionInput;
    }

    /**
     * Gets action input.
     *
     * @return the action input
     */
    public Input getActionInput() {
        return actionInput;
    }

    /**
     * Sets action input.
     *
     * @param actionInput the action input
     */
    public void setActionInput(final Input actionInput) {
        this.actionInput = actionInput;
    }

    /**
     * Gets commands.
     *
     * @return the commands
     */
    public List<ActionInputData> getCommands() {
        return commands;
    }

    /**
     * Sets commands.
     *
     * @param commands the commands
     */
    public void setCommands(final List<ActionInputData> commands) {
        this.commands = commands;
    }

    /**
     * Gets queries.
     *
     * @return the queries
     */
    public List<ActionInputData> getQueries() {
        return queries;
    }


    /**
     * Sets queries.
     *
     * @param queries the queries
     */
    public void setQueries(final List<ActionInputData> queries) {
        this.queries = queries;
    }

    public List<ActionInputData> getRecommendations() {
        return recommendations;
    }

    /**
     * Sets recommendations.
     *
     * @param recommendations the recommendations
     */
    public void setRecommendations(final List<ActionInputData> recommendations) {
        this.recommendations = recommendations;
    }

    /**
     * Gets actions.
     *
     * @return the actions
     */
    public List<ActionInputData> getActions() {
        return actions;
    }

    /**
     * Sets actions.
     *
     * @param actions the actions
     */
    public void setActions(final List<ActionInputData> actions) {
        this.actions = actions;
    }

    /**
     * Categorize.
     * Separates the action types into array lists of commands/queries/recommendations
     */
    public void categorize() {
        for (ActionInputData action : actionInput.getCommands()) {
            if (action.getActionType().equals("command")) {
                commands.add(action);
                actions.add(action);
            }
            if (action.getActionType().equals("query")) {
                queries.add(action);
                actions.add(action);
            }
            if (action.getActionType().equals("recommendation")) {
                recommendations.add(action);
                actions.add(action);
            }
        }
    }

    /**
     * Initialize command command.
     *
     * @return the command
     */
    public Command initializeCommand() {
        if (!commands.isEmpty()) {
            return new Command(commands);
        }
        return null;
    }

    /**
     * Initialize query query.
     *
     * @return the query
     */
    public Query initializeQuery() {
        if (!queries.isEmpty()) {
            return new Query(queries);
        }
        return null;
    }

    /**
     * Initialize recommendation recommendation.
     *
     * @return the recommendation
     */
    public Recommendation initializeRecommendation() {
        if (!recommendations.isEmpty()) {
            return new Recommendation(recommendations);
        }
        return null;
    }

    /**
     * Initialize action action.
     *
     * @return the action
     */
    public Action initializeAction() {
        if (!actions.isEmpty()) {
            return new Action(actions);
        }
        return null;
    }

}
