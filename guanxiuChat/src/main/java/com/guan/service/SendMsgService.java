package com.guan.service;

import java.util.Map;

public interface SendMsgService {
     boolean sendMsg(String phoneNum, Map<String, Object> code);
}
