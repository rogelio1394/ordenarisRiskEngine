package com.ordenaris.risk.rules;

import com.ordenaris.risk.engine.RiskContext;
import com.ordenaris.risk.model.RuleResult;

public interface RiskRule {
    RuleResult evaluate(RiskContext context);
}

