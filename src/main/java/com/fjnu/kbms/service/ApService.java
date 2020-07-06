package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Ap;

public interface ApService {

    Ap getApById(Integer apid);

    void updateScan(Integer apid);
}
