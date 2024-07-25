package com.tech.application.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends Exception {

  private Integer status = 412;
  private final String message;
  private final String code;
  @ToString.Include private Map<String, Object> params;

  public BusinessException(Integer status, String message, String code) {
    super(message);
    this.message = message;
    this.status = status;
    this.code = code;
    this.params = new HashMap<>();
  }

  public void param(String key, Object value) {
    this.params.put(key, value);
  }

  public Object getParams(String key) {
    return this.params.getOrDefault(key, null);
  }

  @Override
  public String getLocalizedMessage() {
    return getFormatedMessage();
  }

  public String getFormatedMessage() {
    String formated = this.getMessage();

    for (Entry<String, Object> entry : params.entrySet()) {
      String regex = "\\[(" + entry.getKey() + ")]";
      formated = formated.replaceAll(regex, entry.getValue().toString());
    }

    return formated;
  }

}
