package com.playbasis.pbcore.rest.form.engine;

import com.playbasis.pbcore.rest.form.CustomParamsForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 8/25/16 AD.
 */
public class EngineRuleForm extends CustomParamsForm {

  protected String action;
  protected String playerId;
  protected String url = null;
  protected String reward = null;
  protected int quantity = -1;
  protected String ruleId = null;
  protected String nodeId = null;
  protected String sessionId = null;

  public EngineRuleForm(String action, String playerId) {
    this.action = action;
    this.playerId = playerId;
  }

  public String getAction() {
    return action;
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setReward(String reward) {
    this.reward = reward;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setRuleId(String ruleId) {
    this.ruleId = ruleId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    map.put("url", url);
    map.put("reward", reward);

    if (quantity != -1) {
      map.put("quantity", quantity);
    }

    map.put("rule_id", ruleId);
    map.put("node_id", nodeId);
    map.put("session_id", sessionId);

    return map;
  }
}
