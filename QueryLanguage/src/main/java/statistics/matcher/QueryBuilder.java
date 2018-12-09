/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jussiste
 */
public class QueryBuilder {

    private List<Matcher> matchers;
    private Matcher current;

    public QueryBuilder() {
        this.matchers = new ArrayList<>();
    }

    public Matcher buildOr() {
        Matcher[] list = new Matcher[this.matchers.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = matchers.get(i);
        }
        matchers=new ArrayList<>();
        return new Or(list);
    }

    public Matcher buildAnd() {
        Matcher[] list = new Matcher[this.matchers.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = matchers.get(i);
        }
        matchers=new ArrayList<>();
        return new And(list);
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        current = new HasAtLeast(value, category);
        this.matchers.add(current);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        current = new HasFewerThan(value, category);
        this.matchers.add(current);
        return this;
    }

    public QueryBuilder not(Matcher... matchers) {
        current = new Not(matchers);
        this.matchers.add(current);
        return this;
    }

    public QueryBuilder or(Matcher... matchers) {
        current = new Or(matchers);
        this.matchers.add(current);
        return this;
    }

    public QueryBuilder all() {
        current = new All();
        this.matchers.add(current);
        return this;
    }

    public QueryBuilder playsIn(String team) {
        current = new PlaysIn(team);
        this.matchers.add(current);
        return this;
    }
}
