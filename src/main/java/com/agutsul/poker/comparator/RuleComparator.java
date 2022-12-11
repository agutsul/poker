package com.agutsul.poker.comparator;

import com.agutsul.poker.rule.Rule;

import java.util.Comparator;

final class RuleComparator implements Comparator<Rule> {

    RuleComparator() {}

    @Override
    public int compare(Rule rule1, Rule rule2) {
        return Integer.compare(rule1.value(), rule2.value());
    }
}